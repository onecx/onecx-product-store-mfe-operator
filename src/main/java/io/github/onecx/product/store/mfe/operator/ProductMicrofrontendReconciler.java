package io.github.onecx.product.store.mfe.operator;

import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;

import org.eclipse.microprofile.config.ConfigProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.onecx.product.store.mfe.operator.client.ProductStoreService;
import io.javaoperatorsdk.operator.api.reconciler.*;
import io.javaoperatorsdk.operator.processing.event.source.filter.OnAddFilter;
import io.javaoperatorsdk.operator.processing.event.source.filter.OnUpdateFilter;

@ControllerConfiguration(onAddFilter = ProductMicrofrontendReconciler.MicrofrontendAddFilter.class, onUpdateFilter = ProductMicrofrontendReconciler.MicrofrontendUpdateFilter.class)
public class ProductMicrofrontendReconciler implements Reconciler<Microfrontend>, ErrorStatusHandler<Microfrontend> {

    private static final Logger log = LoggerFactory.getLogger(ProductMicrofrontendReconciler.class);

    @Inject
    ProductStoreService service;

    private static final boolean MULTI_ENABLED = ConfigProvider.getConfig()
            .getValue("onecx.product.store.mfe.operator.multi-enabled", boolean.class);

    private static final String MULTI_NAME = ConfigProvider.getConfig()
            .getValue("onecx.product.store.mfe.operator.name", String.class);

    @Override
    public UpdateControl<Microfrontend> reconcile(Microfrontend microfrontend, Context<Microfrontend> context)
            throws Exception {

        String mfeId = microfrontend.getSpec().getMfeId();
        String productName = microfrontend.getSpec().getProductName();

        log.info("Reconcile microfrontend: {} for product: {}", mfeId, productName);

        int responseCode = service.updateMicrofrontend(microfrontend);

        updateStatusPojo(microfrontend, responseCode);
        log.info("Microfrontend '{}' reconciled - updating status", microfrontend.getMetadata().getName());
        return UpdateControl.updateStatus(microfrontend);

    }

    @Override
    public ErrorStatusUpdateControl<Microfrontend> updateErrorStatus(Microfrontend microfrontend,
            Context<Microfrontend> context, Exception e) {

        int responseCode = -1;
        if (e.getCause() instanceof WebApplicationException re) {
            responseCode = re.getResponse().getStatus();
        }

        log.error("Error reconcile resource", e);
        MicrofrontendStatus status = new MicrofrontendStatus();
        status.setProductName(null);
        status.setMfeId(null);
        status.setResponseCode(responseCode);
        status.setStatus(MicrofrontendStatus.Status.ERROR);
        status.setMessage(e.getMessage());
        microfrontend.setStatus(status);
        return ErrorStatusUpdateControl.updateStatus(microfrontend);
    }

    private void updateStatusPojo(Microfrontend microfrontend, int responseCode) {
        MicrofrontendStatus result = new MicrofrontendStatus();
        MicrofrontendSpec spec = microfrontend.getSpec();
        result.setProductName(spec.getProductName());
        result.setMfeId(spec.getMfeId());
        result.setResponseCode(responseCode);
        var status = switch (responseCode) {
            case 201:
                yield MicrofrontendStatus.Status.CREATED;
            case 200:
                yield MicrofrontendStatus.Status.UPDATED;
            default:
                yield MicrofrontendStatus.Status.UNDEFINED;
        };
        result.setStatus(status);
        microfrontend.setStatus(result);
    }

    public static class MicrofrontendAddFilter implements OnAddFilter<Microfrontend> {

        @Override
        public boolean accept(Microfrontend resource) {
            return resource.getSpec() != null;
        }
    }

    public static class MicrofrontendUpdateFilter implements OnUpdateFilter<Microfrontend> {

        @Override
        public boolean accept(Microfrontend newResource, Microfrontend oldResource) {
            return newResource.getSpec() != null;
        }
    }

}

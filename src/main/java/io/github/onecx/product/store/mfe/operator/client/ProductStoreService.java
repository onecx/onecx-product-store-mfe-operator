package io.github.onecx.product.store.mfe.operator.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gen.io.github.onecx.product.store.mfe.v1.api.OperatorMfeApi;
import gen.io.github.onecx.product.store.mfe.v1.model.UpdateMfeRequest;
import io.github.onecx.product.store.mfe.operator.Microfrontend;
import io.github.onecx.product.store.mfe.operator.MicrofrontendSpec;
import io.github.onecx.product.store.mfe.operator.client.mappers.ProductStoreMapper;

@ApplicationScoped
public class ProductStoreService {

    private static final Logger log = LoggerFactory.getLogger(ProductStoreService.class);

    @Inject
    @RestClient
    OperatorMfeApi client;

    @Inject
    ProductStoreMapper mapper;

    public int updateMicrofrontend(Microfrontend microfrontend) {
        MicrofrontendSpec spec = microfrontend.getSpec();
        UpdateMfeRequest dto = mapper.map(spec);
        try (var response = client.createOrUpdateMfe(spec.getMfeId(), dto)) {
            log.info("Update micro-fronted response {}", response.getStatus());
            return response.getStatus();
        }
    }
}

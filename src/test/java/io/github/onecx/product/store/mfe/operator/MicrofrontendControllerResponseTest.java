package io.github.onecx.product.store.mfe.operator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import jakarta.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.github.onecx.product.store.mfe.operator.client.ProductStoreService;
import io.github.onecx.product.store.mfe.test.AbstractTest;
import io.javaoperatorsdk.operator.api.reconciler.UpdateControl;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class MicrofrontendControllerResponseTest extends AbstractTest {

    @InjectMock
    ProductStoreService productStoreService;

    @Inject
    MicrofrontendController reconciler;

    @BeforeEach
    void beforeAll() {
        Mockito.when(productStoreService.updateMicrofrontend(any())).thenReturn(404);
    }

    @Test
    void testWrongResponse() throws Exception {

        MicrofrontendSpec s = new MicrofrontendSpec();
        s.setProductName("product");
        s.setAppId("m1");
        s.setAppVersion("m1");
        s.setAppName("m1");

        Microfrontend m = new Microfrontend();
        m.setSpec(s);

        UpdateControl<Microfrontend> result = reconciler.reconcile(m, null);
        assertThat(result).isNotNull();
        assertThat(result.getResource()).isNotNull();
        assertThat(result.getResource().getStatus()).isNotNull();
        assertThat(result.getResource().getStatus().getStatus()).isNotNull().isEqualTo(MicrofrontendStatus.Status.UNDEFINED);

    }
}

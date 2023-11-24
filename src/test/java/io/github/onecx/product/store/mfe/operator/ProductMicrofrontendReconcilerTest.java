package io.github.onecx.product.store.mfe.operator;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

import java.util.stream.Stream;

import jakarta.inject.Inject;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.operator.Operator;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class ProductMicrofrontendReconcilerTest {

    final static Logger log = LoggerFactory.getLogger(ProductMicrofrontendReconcilerTest.class);

    @Inject
    Operator operator;

    @Inject
    KubernetesClient client;

    @BeforeAll
    public static void init() {
        Awaitility.setDefaultPollDelay(2, SECONDS);
        Awaitility.setDefaultPollInterval(2, SECONDS);
        Awaitility.setDefaultTimeout(10, SECONDS);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void microfrontendTest(String name, MicrofrontendSpec spec, String status) {

        operator.start();

        Microfrontend microfrontend = new Microfrontend();
        microfrontend.setMetadata(new ObjectMetaBuilder().withName(name).withNamespace(client.getNamespace()).build());
        microfrontend.setSpec(spec);

        log.info("Creating test microfrontend object: {}", microfrontend);
        client.resource(microfrontend).serverSideApply();

        log.info("Waiting 4 seconds and status muss be still null");

        await().pollDelay(2, SECONDS).untilAsserted(() -> {
            MicrofrontendStatus mfeStatus = client.resource(microfrontend).get().getStatus();
            assertThat(mfeStatus).isNotNull();
            assertThat(mfeStatus.getStatus()).isNotNull().isEqualTo(status);
        });
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("test-1", createSpec("test-1", "product-test", "/test1"), "CREATED"),
                Arguments.of("test-2", createSpec("test-2", "product-test-2", "/test2"), "CREATED"),
                Arguments.of("test-3", createSpec("test-3", "product-test-2", "/test3"), "UPDATED"),
                Arguments.of("test-error-1", createSpec("test-error-1", "product-test-2", "/test2"), "ERROR"),
                Arguments.of("test-error-2", createSpec("test-error-2", "product-test-2", "/test2"), "ERROR"));
    }

    private static MicrofrontendSpec createSpec(String mfeId, String productName, String basePath) {
        MicrofrontendSpec spec = new MicrofrontendSpec();
        spec.setMfeId(mfeId);
        spec.setProductName(productName);
        spec.setBasePath(basePath);
        spec.setProductStore("test");
        spec.setRemoteBaseUrl("test");
        spec.setRemoteName("test");
        spec.setExposedModule("test");
        spec.setDisplayName("dn");
        spec.setModuleType(MicrofrontendSpec.ModuleType.ANGULAR);
        spec.setWcTagName("wc");
        spec.setAppId("appId");
        spec.setAppVersion("app-version");
        spec.setNote("note");
        spec.setContact("contact");
        spec.setRemoteBaseUrl("rbu");
        spec.setRemoteEntry("re");
        return spec;
    }
}

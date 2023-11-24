package io.github.onecx.product.store.mfe.operator;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;

@StaticInitSafe
@ConfigMapping(prefix = "onecx.product.store.mfe.operator")
public interface OperatorConfig {

    @WithName("multi-enabled")
    @WithDefault("false")
    boolean enabled();

    @WithName("name")
    @WithDefault("onecx")
    String name();

}

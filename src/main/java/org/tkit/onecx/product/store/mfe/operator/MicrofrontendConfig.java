package org.tkit.onecx.product.store.mfe.operator;

import io.quarkus.runtime.annotations.ConfigDocFilename;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;

@StaticInitSafe
@ConfigDocFilename("onecx-product-store-mfe-operator.adoc")
@ConfigMapping(prefix = "onecx.product-store.operator.mfe")
@ConfigRoot(phase = ConfigPhase.RUN_TIME)
public interface MicrofrontendConfig {

    /**
     * Leader election configuration
     */
    @WithName("leader-election")
    LeaderElectionConfig leaderElectionConfig();

    /**
     * Leader election config
     */
    interface LeaderElectionConfig {

        /**
         * Lease name
         */
        @WithName("lease-name")
        @WithDefault("onecx-product-store-mfe-operator-lease")
        String leaseName();
    }
}

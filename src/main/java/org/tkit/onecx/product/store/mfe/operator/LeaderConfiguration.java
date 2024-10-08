package org.tkit.onecx.product.store.mfe.operator;

import jakarta.inject.Singleton;

import io.javaoperatorsdk.operator.api.config.LeaderElectionConfiguration;

@Singleton
public class LeaderConfiguration extends LeaderElectionConfiguration {

    public LeaderConfiguration(MicrofrontendConfig config) {
        super(config.leaderElectionConfig().leaseName());
    }
}

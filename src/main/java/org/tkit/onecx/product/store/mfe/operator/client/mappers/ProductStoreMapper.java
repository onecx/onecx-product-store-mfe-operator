package org.tkit.onecx.product.store.mfe.operator.client.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tkit.onecx.product.store.mfe.operator.MicrofrontendSpec;

import gen.org.tkit.onecx.product.store.mfe.v1.model.UpdateMfeRequest;

@Mapper
public interface ProductStoreMapper {

    @Mapping(target = "undeployed", constant = "false")
    UpdateMfeRequest map(MicrofrontendSpec spec);

}

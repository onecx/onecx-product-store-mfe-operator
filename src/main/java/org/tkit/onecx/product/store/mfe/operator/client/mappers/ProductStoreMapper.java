package org.tkit.onecx.product.store.mfe.operator.client.mappers;

import org.mapstruct.Mapper;
import org.tkit.onecx.product.store.mfe.operator.MicrofrontendSpec;

import gen.org.tkit.onecx.product.store.mfe.v1.model.UpdateMfeRequest;

@Mapper
public interface ProductStoreMapper {

    UpdateMfeRequest map(MicrofrontendSpec spec);

}

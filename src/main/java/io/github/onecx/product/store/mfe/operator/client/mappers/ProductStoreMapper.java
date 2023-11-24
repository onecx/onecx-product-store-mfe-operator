package io.github.onecx.product.store.mfe.operator.client.mappers;

import org.mapstruct.Mapper;

import gen.io.github.onecx.product.store.mfe.v1.model.UpdateMfeRequest;
import io.github.onecx.product.store.mfe.operator.MicrofrontendSpec;

@Mapper
public interface ProductStoreMapper {

    UpdateMfeRequest map(MicrofrontendSpec spec);
}

package io.github.onecx.product.store.mfe.operator.client.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import gen.io.github.onecx.product.store.mfe.v1.model.UpdateMfeRequest;
import io.github.onecx.product.store.mfe.operator.MicrofrontendSpec;

@Mapper
public interface ProductStoreMapper {

    @Mapping(target = "classifications", qualifiedByName = "setToString")
    UpdateMfeRequest map(MicrofrontendSpec spec);

    @Named("setToString")
    default String setToString(Set<String> classifications) {
        if (classifications != null && !classifications.isEmpty()) {
            return classifications.stream().map(Object::toString).collect(Collectors.joining(","));
        }
        return "";
    }
}

package com.icn.barleystation.support;

import com.icn.barleystation.util.Util;
import org.mapstruct.Named;

public interface EntityMapper<D, E> {

    E toEntity(D dto);


    @Named("toUppperCase")
    default String toUppperCase(String value) {
        if(!Util.isNull(value)) {
            return value.toUpperCase();
        }
        return value;
    }

    @Named("toLowerCase")
    default String toLowerCase(String value) {
        if(!Util.isNull(value)) {
            return value.toLowerCase();
        }
        return value;
    }

}

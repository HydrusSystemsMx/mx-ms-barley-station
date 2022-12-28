package com.icn.barleystation.support;

import java.util.List;

public interface DTOMapper<D, E> {

    D toDTO(E entity);

    List<D> toDTOS(List<E> entities);

}

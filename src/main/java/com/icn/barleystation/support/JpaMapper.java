package com.icn.barleystation.support;

import com.icn.barleystation.model.DTO;
import com.icn.barleystation.model.Entities;
import com.icn.barleystation.support.ex.JpaMapperException;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Mapper(componentModel = "spring")
public class JpaMapper {

    @PersistenceContext
    protected EntityManager em;

    @ObjectFactory
    public <E extends Entities> E reference(DTO dto, @TargetType Class<E> entityClass) {
        try {
            return (dto.getId() != null) ? em.getReference(entityClass, dto.getId()) : entityClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new JpaMapperException("A ocurrido un error trantado de obtener la referencia a la entidad", e);
        }
    }

}

package com.icn.barleystation.support;

import com.icn.barleystation.model.PaginacionDto;
import com.icn.barleystation.model.PaginacionResultadoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface JpaPage<D, E> extends DTOMapper<D, E> {

    Integer TAMANO_MAXIMO_PAGINA = 50;
    Integer TAMANO_PAGINA_POR_DEFECTO = 10;
    Integer PAGINA_POR_DEFECTO = 0;
    String COLUMNA_ORDEN_POR_DEFECTO = "id";

    default PageRequest solicitudPaginacion(PaginacionDto paginacionDto) {
        return PageRequest.of(
                Optional.ofNullable(paginacionDto.getPagina())
                        .orElse(PAGINA_POR_DEFECTO),
                Optional.ofNullable(paginacionDto.getTamano())
                        .map(tamano -> Math.min(TAMANO_MAXIMO_PAGINA, tamano))
                        .orElse(TAMANO_PAGINA_POR_DEFECTO),
                Sort.by(
                        Sort.Direction.fromOptionalString(paginacionDto.getOrden()).orElse(Sort.Direction.DESC),
                        Optional.ofNullable(paginacionDto.getColumnaOrden()).orElse(COLUMNA_ORDEN_POR_DEFECTO)
                )
        );
    }

    default PaginacionResultadoDto<D> resultadoPaginacion(Page<E> pagina) {
        PaginacionResultadoDto paginacionResultadoDto = new PaginacionResultadoDto();
        paginacionResultadoDto.setDatos(toDTOS(pagina.getContent()));
        paginacionResultadoDto.setTotalFilas(pagina.getTotalElements());
        paginacionResultadoDto.setTamanoPagina(pagina.getSize());
        paginacionResultadoDto.setNumeroPagina(pagina.getNumber());
        paginacionResultadoDto.setTotalPaginas(pagina.getTotalPages());
        return paginacionResultadoDto;
    }
}

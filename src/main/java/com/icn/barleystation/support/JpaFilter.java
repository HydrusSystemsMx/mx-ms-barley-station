package com.icn.barleystation.support;

import com.icn.barleystation.model.PaginacionFiltroDto;

public interface JpaFilter {

  default String filtroLike(PaginacionFiltroDto paginacionFiltroDto) {
    String filtro = paginacionFiltroDto.getFiltroLike();
    filtro = ("".equals(filtro) || "*".equals(filtro)) ? "%" : filtro;
    filtro = String.format("%s%%", filtro);
    return filtro;
  }

}

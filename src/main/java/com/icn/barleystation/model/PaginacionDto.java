package com.icn.barleystation.model;

import lombok.Getter;
import lombok.Setter;

public class PaginacionDto extends PaginacionFiltroDto {

  private Integer pagina;

  private Integer tamano;

  private String orden;

  private String columnaOrden;

  public Integer getPagina() {
    return pagina;
  }

  public void setPagina(Integer pagina) {
    this.pagina = pagina;
  }

  public Integer getTamano() {
    return tamano;
  }

  public void setTamano(Integer tamano) {
    this.tamano = tamano;
  }

  public String getOrden() {
    return orden;
  }

  public void setOrden(String orden) {
    this.orden = orden;
  }

  public String getColumnaOrden() {
    return columnaOrden;
  }

  public void setColumnaOrden(String columnaOrden) {
    this.columnaOrden = columnaOrden;
  }
}

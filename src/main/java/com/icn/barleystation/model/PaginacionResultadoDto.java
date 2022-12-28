package com.icn.barleystation.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PaginacionResultadoDto<T> {

  private List<T> datos;

  private Long totalFilas;

  private Integer tamanoPagina;

  private Integer numeroPagina;

  private Integer totalPaginas;

  public List<T> getDatos() {
    return datos;
  }

  public void setDatos(List<T> datos) {
    this.datos = datos;
  }

  public Long getTotalFilas() {
    return totalFilas;
  }

  public void setTotalFilas(Long totalFilas) {
    this.totalFilas = totalFilas;
  }

  public Integer getTamanoPagina() {
    return tamanoPagina;
  }

  public void setTamanoPagina(Integer tamanoPagina) {
    this.tamanoPagina = tamanoPagina;
  }

  public Integer getNumeroPagina() {
    return numeroPagina;
  }

  public void setNumeroPagina(Integer numeroPagina) {
    this.numeroPagina = numeroPagina;
  }

  public Integer getTotalPaginas() {
    return totalPaginas;
  }

  public void setTotalPaginas(Integer totalPaginas) {
    this.totalPaginas = totalPaginas;
  }
}
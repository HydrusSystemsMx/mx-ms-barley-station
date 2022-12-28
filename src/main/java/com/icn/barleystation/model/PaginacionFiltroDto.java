package com.icn.barleystation.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class PaginacionFiltroDto {

    private String filtroLike;

    private LocalDateTime fechaInicial;

    private LocalDateTime fechaFinal;

    public String getFiltroLike() {
        return filtroLike;
    }

    public void setFiltroLike(String filtroLike) {
        this.filtroLike = filtroLike;
    }

    public LocalDateTime getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDateTime fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDateTime getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDateTime fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}

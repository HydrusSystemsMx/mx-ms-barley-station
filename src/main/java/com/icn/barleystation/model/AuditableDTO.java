package com.icn.barleystation.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class AuditableDTO implements Serializable {

    protected String creadoPor;

    protected LocalDate fechaCreacion;

    protected String modificadoPor;

    protected LocalDate ultimaModificacion;
}


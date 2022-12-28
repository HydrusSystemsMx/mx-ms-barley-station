package com.icn.barleystation.model;

public class DTO<ID> extends AuditableDTO {

    protected ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}

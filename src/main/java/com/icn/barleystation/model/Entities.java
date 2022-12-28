package com.icn.barleystation.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract class Entities<K extends Serializable> extends Auditable implements Persistable<K> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected K id;

    @Override
    public K getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return (this.id == null);
    }
}

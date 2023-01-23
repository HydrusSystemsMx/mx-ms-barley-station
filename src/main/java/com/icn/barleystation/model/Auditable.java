package com.icn.barleystation.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements Serializable {

    @CreatedDate
    @Column(name = "create_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createDate;

    @LastModifiedDate
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updateDate;
}

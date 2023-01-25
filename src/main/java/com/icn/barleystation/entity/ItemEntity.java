package com.icn.barleystation.entity;

import com.icn.barleystation.model.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ITEM")
@Entity
public class ItemEntity extends Entities<Long> implements Serializable {
	@Column(name = "nameItem")
	private String nameItem;
	@Column(name = "price")
	private Double price;
	@Column(name = "image")
	private String image;
	@Column(name = "details")
	private String details;
	@Column(name = "status")
	private boolean status;
	@OneToOne // Relacion uno a uno
	@JoinColumn(name = "idBrand")
	private BrandEntity brand;
}

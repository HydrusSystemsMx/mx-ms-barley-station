package com.icn.barleystation.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.icn.barleystation.model.Entities;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BRAND")
@Entity
public class BrandEntity extends Entities<Long> implements Serializable {

	@Column(name = "brand_name")
	private String brandName;
	@Column(name = "status")
	private boolean status;
	@Column(name = "image")
	private String image;

}

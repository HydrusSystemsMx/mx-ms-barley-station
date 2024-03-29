package com.icn.barleystation.entity;

import com.icn.barleystation.model.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BANNER")
public class BannerEntity extends Entities<Long> implements Serializable {

	@Column(name = "url")
	private String url;

	@Column(name = "status")
	private boolean status;

}

package com.icn.barleystation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.Nullable;

@Entity
@Table(name = "DELIVERY")
public class DeliveryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDelivery;
	private String name;
	private String lastName;
	private String SecondName;
	@Nullable
	private Date createdDate;
	private Integer branch;
	private Boolean status;
	private Boolean avaliable;

	public Integer getIdDelivery() {
		return idDelivery;
	}

	public void setIdDelivery(Integer idDelivery) {
		this.idDelivery = idDelivery;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondName() {
		return SecondName;
	}

	public void setSecondName(String secondName) {
		SecondName = secondName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getBranch() {
		return branch;
	}

	public void setBranch(Integer branch) {
		this.branch = branch;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getAvaliable() {
		return avaliable;
	}

	public void setAvaliable(Boolean avaliable) {
		this.avaliable = avaliable;
	}

	@Override
	public String toString() {
		return "DeliveryEntity [idDelivery=" + idDelivery + ", name=" + name + ", lastName=" + lastName
				+ ", SecondName=" + SecondName + ", createdDate=" + createdDate + ", branch=" + branch + ", status="
				+ status + ", avaliable=" + avaliable + "]";
	}

}

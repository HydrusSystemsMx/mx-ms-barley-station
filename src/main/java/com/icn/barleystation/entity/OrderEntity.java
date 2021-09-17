package com.icn.barleystation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BARLEYREQUEST")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBarleyrequest;
	private Integer idRequest;
	private Integer idUser;
	private Integer amount;
	private Integer idItem;
	private String deliveryLocation;
	private Double moneyPrice;
	private Date createdDate;
	private Date deliveryDate;
	private Double total;

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	public Double getMoneyPrice() {
		return moneyPrice;
	}

	public void setMoneyPrice(Double moneyPrice) {
		this.moneyPrice = moneyPrice;
	}

	public Integer getIdBarleyrequest() {
		return idBarleyrequest;
	}

	public void setIdBarleyrequest(Integer idBarleyrequest) {
		this.idBarleyrequest = idBarleyrequest;
	}

	public Integer getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}

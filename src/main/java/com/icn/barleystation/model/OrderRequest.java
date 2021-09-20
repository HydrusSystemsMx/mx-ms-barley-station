package com.icn.barleystation.model;

import java.io.Serializable;
import java.util.List;

import com.icn.barleystation.entity.OrderEntity;

public class OrderRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<OrderEntity> orderList;
	private String deliveryLocation;
	private String idRequest;
	private Integer idUser;
	private Double total;
	private Integer payMethod;

	public List<OrderEntity> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderEntity> orderList) {
		this.orderList = orderList;
	}

	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	public String getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(String idRequest) {
		this.idRequest = idRequest;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}
	
	

}

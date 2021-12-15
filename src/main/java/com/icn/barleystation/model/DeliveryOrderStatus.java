package com.icn.barleystation.model;

import java.io.Serializable;
import java.util.List;

import com.icn.barleystation.entity.OrderEntity;

public class DeliveryOrderStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	public String name;
	public List<OrderEntity> currentOrder;
	public List<ErrorTO> errors;
	public String action;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ErrorTO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorTO> errors) {
		this.errors = errors;
	}

	public List<OrderEntity> getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(List<OrderEntity> currentOrder) {
		this.currentOrder = currentOrder;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}

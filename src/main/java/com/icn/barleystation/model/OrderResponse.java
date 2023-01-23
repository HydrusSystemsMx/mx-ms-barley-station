package com.icn.barleystation.model;

import java.io.Serializable;
import java.util.List;

import com.icn.barleystation.entity.OrderEntity;
import com.icn.barleystation.model.errors.ErrorTO;

public class OrderResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<OrderEntity> response;
	private List<ErrorTO> errors;

	public List<OrderEntity> getResponse() {
		return response;
	}

	public void setResponse(List<OrderEntity> response) {
		this.response = response;
	}

	public List<ErrorTO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorTO> errors) {
		this.errors = errors;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

package com.icn.barleystation.model;

import java.io.Serializable;
import java.util.List;

import com.icn.barleystation.entity.DeliveryEntity;

public class DeliveryResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	public List<DeliveryEntity> response;
	private List<ErrorTO> errors;

	public List<DeliveryEntity> getResponse() {
		return response;
	}

	public void setResponse(List<DeliveryEntity> response) {
		this.response = response;
	}

	public List<ErrorTO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorTO> errors) {
		this.errors = errors;
	}

}

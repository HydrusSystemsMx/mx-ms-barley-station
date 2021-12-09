package com.icn.barleystation.model;

import java.io.Serializable;

import com.icn.barleystation.entity.DeliveryEntity;

public class DeliveryRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private DeliveryEntity request;

	public DeliveryEntity getRequest() {
		return request;
	}

	public void setRequest(DeliveryEntity request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "DeliveryRequest [request=" + request + "]";
	}

}

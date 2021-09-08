package com.icn.barleystation.model;

import java.io.Serializable;

import com.icn.barleystation.entity.InventoryEntity;

public class InventoryRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private InventoryEntity inventoryRequest;

	public InventoryEntity getInventoryRequest() {
		return inventoryRequest;
	}

	public void setInventoryRequest(InventoryEntity inventoryRequest) {
		this.inventoryRequest = inventoryRequest;
	}

}

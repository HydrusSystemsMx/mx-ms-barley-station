package com.icn.barleystation.model;

import java.io.Serializable;

import com.icn.barleystation.entity.ItemEntity;

public class RequestItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private ItemEntity requestItem;

	public ItemEntity getRequestItem() {
		return requestItem;
	}

	public void setRequestItem(ItemEntity requestItem) {
		this.requestItem = requestItem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RequestItem [request=" + requestItem + "]";
	}

}

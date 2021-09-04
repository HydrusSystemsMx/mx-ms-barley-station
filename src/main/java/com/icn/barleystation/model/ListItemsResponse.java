package com.icn.barleystation.model;

import java.io.Serializable;
import java.util.List;

import com.icn.barleystation.entity.ItemEntity;

public class ListItemsResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ItemEntity> response;

	public List<ItemEntity> getResponse() {
		return response;
	}

	public void setResponse(List<ItemEntity> response) {
		this.response = response;
	}

}

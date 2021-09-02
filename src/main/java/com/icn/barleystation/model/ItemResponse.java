package com.icn.barleystation.model;

import java.io.Serializable;
import java.util.List;

import com.icn.barleystation.entity.ItemEntity;

public class ItemResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ErrorTO> errors;
	private ItemEntity response;

	public ItemEntity getResponse() {
		return response;
	}

	public void setResponse(ItemEntity response) {
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

	@Override
	public String toString() {
		return "ItemResponse [errors=" + errors + ", response=" + response + "]";
	}

}

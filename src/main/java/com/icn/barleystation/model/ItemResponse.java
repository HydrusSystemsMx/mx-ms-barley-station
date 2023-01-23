package com.icn.barleystation.model;

import java.io.Serializable;
import java.util.List;

import com.icn.barleystation.entity.ItemEntity;
import com.icn.barleystation.model.errors.ErrorTO;

public class ItemResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ErrorTO> errors;
	private ItemEntity response;
	private Integer stack;

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

	public Integer getStack() {
		return stack;
	}

	public void setStack(Integer stack) {
		this.stack = stack;
	}

	@Override
	public String toString() {
		return "ItemResponse [errors=" + errors + ", response=" + response + "]";
	}

}

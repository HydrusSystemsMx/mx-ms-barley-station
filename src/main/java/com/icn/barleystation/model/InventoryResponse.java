package com.icn.barleystation.model;

import java.io.Serializable;
import java.util.List;

import com.icn.barleystation.entity.InventoryEntity;
import com.icn.barleystation.model.errors.ErrorTO;

public class InventoryResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ErrorTO> errors;

	private InventoryEntity response;

	public List<ErrorTO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorTO> errors) {
		this.errors = errors;
	}

	public InventoryEntity getResponse() {
		return response;
	}

	public void setResponse(InventoryEntity response) {
		this.response = response;
	}
}

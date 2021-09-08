package com.icn.barleystation.model;

import java.io.Serializable;
import java.util.List;

public class InventoryStack implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer stack;
	private List<ErrorTO> errors;
	public Integer getStack() {
		return stack;
	}
	public void setStack(Integer stack) {
		this.stack = stack;
	}
	public List<ErrorTO> getErrors() {
		return errors;
	}
	public void setErrors(List<ErrorTO> errors) {
		this.errors = errors;
	}
	
	

}

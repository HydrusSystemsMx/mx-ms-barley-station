package com.icn.barleystation.model;

import java.io.Serializable;
import java.util.List;

import com.icn.barleystation.entity.BrandEntity;

public class BrandResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ErrorTO> errors;
	private BrandEntity response;

	public List<ErrorTO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorTO> errors) {
		this.errors = errors;
	}

	public BrandEntity getResponse() {
		return response;
	}

	public void setResponse(BrandEntity response) {
		this.response = response;
	}

}

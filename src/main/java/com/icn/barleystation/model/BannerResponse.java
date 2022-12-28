package com.icn.barleystation.model;

import java.io.Serializable;
import java.util.List;

import com.icn.barleystation.entity.BannerEntity;

public class BannerResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	public BannerDTO response;
	private List<ErrorTO> errors;

	public BannerDTO getResponse() {
		return response;
	}

	public void setResponse(BannerDTO response) {
		this.response = response;
	}

	public List<ErrorTO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorTO> errors) {
		this.errors = errors;
	}
}

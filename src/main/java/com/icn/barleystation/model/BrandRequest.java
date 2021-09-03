package com.icn.barleystation.model;

import java.io.Serializable;

import com.icn.barleystation.entity.BrandEntity;

public class BrandRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private BrandEntity requestBrand;

	public BrandEntity getRequestBrand() {
		return requestBrand;
	}

	public void setRequestBrand(BrandEntity requestBrand) {
		this.requestBrand = requestBrand;
	}

	@Override
	public String toString() {
		return "BrandRequest [requestBrand=" + requestBrand + "]";
	}

}

package com.icn.barleystation.model;

import java.io.Serializable;
import java.util.Date;

import com.sun.istack.Nullable;

public class BannerRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String url;
	private Date cratedDate;

	@Nullable
	private Boolean status;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCratedDate() {
		return cratedDate;
	}

	public void setCratedDate(Date cratedDate) {
		this.cratedDate = cratedDate;
	}

}

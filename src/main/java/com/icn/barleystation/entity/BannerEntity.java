package com.icn.barleystation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANNER")
public class BannerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBanner;
	private String url;
	private Date createdDate;
	private Boolean status;

	public Integer getIdBanner() {
		return idBanner;
	}

	public void setIdBanner(Integer idBanner) {
		this.idBanner = idBanner;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}

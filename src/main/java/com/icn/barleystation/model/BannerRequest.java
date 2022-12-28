package com.icn.barleystation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BannerRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("url")
	private String url;

	@JsonProperty("status")
	@Nullable
	private Boolean status;

}

package com.icn.barleystation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.Nullable;

import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("name")
	private String name;

	@JsonProperty("status")
	@Nullable
	private Boolean status;

	@JsonProperty("profileImage")
	private String profileImage;

	@JsonProperty("mail")
	private String mail;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("address")
	private String address;

	@JsonProperty("createdDate")
	@JsonIgnore
	private Date createdDate;
}

package com.icn.barleystation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.icn.barleystation.model.errors.ErrorTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

	private Long idUser;
	private String name;
	private Boolean status;
	private String profileImage;
	private String mail;
	private String phone;
	private String password;
	private String address;
	private Date createdDate;
	private List<ErrorTO> errors;
}

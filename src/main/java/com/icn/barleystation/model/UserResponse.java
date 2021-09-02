package com.icn.barleystation.model;

import java.io.Serializable;
import java.util.List;

import com.icn.barleystation.entity.UserEntity;

public class UserResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private UserEntity response;
	private List<ErrorTO> errors;

	public UserEntity getResponse() {
		return response;
	}

	public void setResponse(UserEntity response) {
		this.response = response;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<ErrorTO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorTO> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "UserResponse [response=" + response + ", errors=" + errors + "]";
	}

}

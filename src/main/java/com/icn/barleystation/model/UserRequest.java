package com.icn.barleystation.model;

import java.io.Serializable;

import com.icn.barleystation.entity.UserEntity;

public class UserRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private UserEntity requestUser;

	public UserEntity getRequestUser() {
		return requestUser;
	}

	public void setRequestUser(UserEntity requestUser) {
		this.requestUser = requestUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserRequest [requestUser=" + requestUser + "]";
	}

}

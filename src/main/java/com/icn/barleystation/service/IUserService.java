package com.icn.barleystation.service;

import org.springframework.http.ResponseEntity;

import com.icn.barleystation.model.UserRequest;
import com.icn.barleystation.model.UserResponse;

public interface IUserService {

	ResponseEntity<UserResponse> createNewUser(UserRequest request);

	ResponseEntity<UserResponse> getUserById(Integer idUser);
}

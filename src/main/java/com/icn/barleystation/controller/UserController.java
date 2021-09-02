package com.icn.barleystation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icn.barleystation.model.UserRequest;
import com.icn.barleystation.model.UserResponse;
import com.icn.barleystation.service.IUserService;

@RestController
@RequestMapping("/api/v1/barley/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping("/create")
	public ResponseEntity<UserResponse> createNewUser(@RequestBody UserRequest request) {
		System.out.println("createNewwUser()");
		return userService.createNewUser(request);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Integer id) {
		System.out.println("userService()");
		return userService.getUserById(id);
	}

}

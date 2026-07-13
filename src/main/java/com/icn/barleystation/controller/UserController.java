package com.icn.barleystation.controller;

import com.icn.barleystation.handler.UserHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import com.icn.barleystation.model.UserRequest;
import com.icn.barleystation.model.UserResponse;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/barley/users")
public class UserController {

	private final UserHandler userHandler;

	@PostMapping("/create")
	public UserResponse createNewUser(@RequestBody UserRequest request) {
		System.out.println("createNewUser()");
		return userHandler.createNewUser(request);
	}

	@GetMapping("/search")
	public UserResponse getUserByEmail(@RequestParam("email") String email) {
		log.info("Buscando usuario: {}", email);
		return userHandler.getUserByEmail(email);
	}

	@GetMapping("/{id}")
	public UserResponse getUserById(@PathVariable("id") Long id) {
		System.out.println("userService()");
		return userHandler.getUserById(id);
	}


}

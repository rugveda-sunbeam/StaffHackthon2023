package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddUserDTO;
import com.app.dto.AuthRequest;
import com.app.dto.UserRespDTO;
import com.app.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;



	@PostMapping("/add")
	public ResponseEntity<String> addNewUser(@RequestBody AddUserDTO requestDTO) {

		System.out.println("in add new user " + requestDTO);
		userService.addUesrDetails(requestDTO);
		return ResponseEntity.ok("User Added Successfully");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> signInUser(@RequestBody AuthRequest request) {
		System.out.println("auth req " + request);
		// try {
		UserRespDTO resp = userService.signInUser(request);
		return ResponseEntity.ok(resp);
	}

}

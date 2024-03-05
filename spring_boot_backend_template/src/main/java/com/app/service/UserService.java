package com.app.service;

import javax.validation.Valid;

import com.app.dto.AddUserDTO;
import com.app.dto.AuthRequest;
import com.app.dto.UserRespDTO;

public interface UserService {
	UserRespDTO addUesrDetails(AddUserDTO user);

	UserRespDTO signInUser(@Valid AuthRequest request);

	UserRespDTO getUserById(Long id);
}

package com.app.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserRepository;
import com.app.dto.AddUserDTO;
import com.app.dto.AuthRequest;
import com.app.dto.UserRespDTO;
import com.app.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public UserRespDTO addUesrDetails(AddUserDTO userdto) {
		User user = mapper.map(userdto, User.class);
		user.setUsername(userdto.getUsername());
		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setMobile(userdto.getMobile());
		user.setRole(userdto.getRole());

		User persistuser = userRepo.save(user);

		// You can return the saved user as a DTO if needed
		return mapper.map(persistuser, UserRespDTO.class);

	}

	@Override
	public UserRespDTO signInUser(AuthRequest request) {
		User user = userRepo.findByUsernameAndPassword(request.getUsername(), request.getPassword())
				.orElseThrow(() -> new RuntimeException("Invalid username or password"));

		return mapper.map(user, UserRespDTO.class);
	}

	@Override
	public UserRespDTO getUserById(Long id) {
		User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
		return mapper.map(user, UserRespDTO.class);
	}
}

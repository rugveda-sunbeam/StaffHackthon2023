package com.app.dto;

import com.app.entities.Role;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserRespDTO {
	private Long id;
	private String username;
	private String name;
	private String email;
	private String mobile;
	private Role role;
	


}

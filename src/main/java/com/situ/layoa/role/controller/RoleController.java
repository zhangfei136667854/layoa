package com.situ.layoa.role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@PostMapping
	public Long doPost(Role role) {
		return roleService.doPost(role);
	}

	@GetMapping("/checkRoleCode")
	public Integer doGet(String roleCode) {
		int num = 1;
		Role role = roleService.doGet(roleCode);
		if (role != null) {
			num = 0;
		}

		return num;
	}
}

package com.situ.layoa.role.service;

import com.situ.layoa.role.domain.Role;

public interface RoleService {

	Long doPost(Role role);

	Role doGet(String roleCode);
	

}

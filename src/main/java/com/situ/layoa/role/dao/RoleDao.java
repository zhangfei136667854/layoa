package com.situ.layoa.role.dao;

import org.springframework.stereotype.Repository;


import com.situ.layoa.role.domain.Role;
@Repository
public interface RoleDao  {

	Role getByRoleCode(String roleCode);
	Long save(Role role);

}

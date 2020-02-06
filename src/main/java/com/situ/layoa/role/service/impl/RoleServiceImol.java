package com.situ.layoa.role.service.impl;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.layoa.role.dao.RoleDao;
import com.situ.layoa.role.domain.Role;
import com.situ.layoa.role.service.RoleService;
@Service
public class RoleServiceImol implements Serializable, RoleService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RoleDao roleDao ;

	@Override
	public Long doPost(Role role) {
		role.setActiveFlag(1);
		role.setCreateBy("admin");
		role.setCreateDate(new Date());
		return roleDao.save(role);
	}

	@Override
	public Role doGet(String roleCode) {
		// TODO Auto-generated method stub
		return roleDao.getByRoleCode(roleCode);
	}

}

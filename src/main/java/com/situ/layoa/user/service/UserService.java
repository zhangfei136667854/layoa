package com.situ.layoa.user.service;

import java.util.List;

import com.situ.layoa.base.FieldParam;
import com.situ.layoa.user.domain.User;

public interface UserService {
	Long saveUser(User user, Integer userKind);

	void initAdminData();

	List<User> findAllUser();

	String checkUserCode(FieldParam fieldParam);

	Long addUser(User user);

	Integer doUserLock(Long rowId, Integer isLock);
	
	Integer getCount();
}

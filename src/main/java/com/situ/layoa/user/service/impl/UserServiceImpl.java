package com.situ.layoa.user.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.layoa.base.FieldParam;
import com.situ.layoa.user.dao.UserDao;
import com.situ.layoa.user.domain.User;
import com.situ.layoa.user.service.UserService;
import com.situ.layoa.util.ConfigUtils;
import com.situ.layoa.util.JSONUtils;
import com.situ.layoa.util.MD5Utils;


@Service
public class UserServiceImpl implements UserService {
	private static final Log LOG = LogFactory.getLog(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;

	@Override
	public Long saveUser(User user, Integer userKind) {
		// TODO Auto-generated method stub
		return null;
	}

	// @PostConstruct 当UserServiceImpl这个实例生成以后，会马上自动调用这个方法。
	@Override
	@PostConstruct
	public void initAdminData() {
		LOG.info("当UserServiceImpl这个实例生成以后，会马上自动调用这个方法。");
		String userCode = "admin";
		String userPass = "123456";
		// 判断当前数据库中是否有这个用户
		User user = userDao.findByCode(userCode);
		if (user == null) {
			user = new User();
			user.setUserName("管理员");
			user.setUserCode(userCode);
			user.setUserPass(MD5Utils.encode(userPass));
			user.setUserKind(User.USER_KIND_ADMIN);
			user.setIsLock(User.IS_LOCK_NO);
			user.setActiveFlag(1);
			user.setCreateBy(ConfigUtils.SYS);
			user.setCreateDate(new Date());
			this.userDao.save(user);
		}
	}

	/** 
	 * @Title: findAllUser 
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @return  
	 */
	//查看所有用户
	@Override
	public List<User> findAllUser() {
		return userDao.find();
	}

	/** 
	 * @Title: checkUserCode 
	 * @Description:(checkUserCode )
	 * @param fieldParam
	 * @return  
	 */
	//用户账号校检
	@Override
	public String checkUserCode(FieldParam fieldParam) {
		Boolean bool = userDao.findByCode(fieldParam.getFieldValue()) == null ? true : false;
		return JSONUtils.buildValidationInfo(fieldParam.getFieldId(), bool);
	}
   //管理员新增
	@Override
	public Long addUser(User user) {
		String userPass = user.getUserPass();
		if (userPass != null) {//避免空指针错误
			user.setUserPass(MD5Utils.encode(userPass));
		}
		user.setUserKind(User.USER_KIND_ADMIN);
		user.setIsLock(User.IS_LOCK_NO);
		user.setActiveFlag(1);
		user.setCreateBy(ConfigUtils.SYS);
		user.setCreateDate(new Date());
		return this.userDao.save(user);
	}
//修改用户状态
	@Override
	public Integer doUserLock(Long rowId, Integer isLock) {
		this.userDao.update4Lock(rowId, isLock);
		return 1;
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		return userDao.count();
	}

}

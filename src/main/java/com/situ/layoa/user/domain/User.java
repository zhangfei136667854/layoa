package com.situ.layoa.user.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.situ.layoa.base.BaseClass;

/**
 * 用户类
 * 
 * @author wxinpeng
 */
@Alias("User")
public class User extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int USER_KIND_ADMIN = 1;
	public static final int USER_KIND_SELLER = 2;
	public static final int IS_LOCK_NO = 0;
	public static final int IS_LOCK_YES = 1;
	private Integer userKind;// 用户类型#1:商家;2:买家;
	private String userName;
	private String userCode;
	private String userPass;
	private String userPhone;
	private Integer isLock;// 是否锁定#1:是;0:否;
	private String lastLoginIP;
	
	private Date lastLoginDate;

	public Integer getUserKind() {
		return userKind;
	}

	public void setUserKind(Integer userKind) {
		this.userKind = userKind;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	
	
}

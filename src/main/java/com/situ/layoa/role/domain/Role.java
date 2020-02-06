package com.situ.layoa.role.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.layoa.base.BaseClass;
@Alias("Role")
public class Role extends BaseClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String roleCode ;//角色编号
    private String roleName ; //角色名称
    private Integer roleKind ; // 角色类型
    private String roleInfo ; //角色简介
	/**
	 * @return the roleCode
	 */
	public String getRoleCode() {
		return roleCode;
	}
	/**
	 * @param roleCode the roleCode to set
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the roleKind
	 */
	public Integer getRoleKind() {
		return roleKind;
	}
	/**
	 * @param roleKind the roleKind to set
	 */
	public void setRoleKind(Integer roleKind) {
		this.roleKind = roleKind;
	}
	/**
	 * @return the roleInfo
	 */
	public String getRoleInfo() {
		return roleInfo;
	}
	/**
	 * @param roleInfo the roleInfo to set
	 */
	public void setRoleInfo(String roleInfo) {
		this.roleInfo = roleInfo;
	}
	@Override
	public String toString() {
		return "Role [roleCode=" + roleCode + ", roleName=" + roleName + ", roleKind=" + roleKind + ", roleInfo="
				+ roleInfo + "]";
	}

}

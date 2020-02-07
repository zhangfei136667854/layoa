/**
 * @Company:中享思途   
 * @Title:UserController.java ，用户后台管理
 * @Author:wxinpeng   
 * @Date:2020年1月8日 上午9:54:17     
 */
package com.situ.layoa.user.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.layoa.base.FieldParam;
import com.situ.layoa.commons.LayuiResult;
import com.situ.layoa.user.domain.User;
import com.situ.layoa.user.service.UserService;

/** 
 * @ClassName:UserController 
 * @Description:(用户的Controller层)  
 */
@Controller
@RequestMapping("/user")
public class UserController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_USER_INDEX = "user/user_index";
	private static final String PAGE_USER_LIST = "user/user_list";
	@Autowired
	private UserService userService;
//后台用户管理主页面
	@RequestMapping("/index")
	public ModelAndView goIdnex(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_USER_INDEX);
		return modelAndView;
	}
//ajax查看用户信息
	@RequestMapping("/list")
	public ModelAndView findAllUser(ModelAndView modelAndView) {
		modelAndView.addObject("userList", userService.findAllUser());
		modelAndView.setViewName(PAGE_USER_LIST);
		return modelAndView;
	}
//用户新增
	@ResponseBody
	@RequestMapping("/add")
	public Long addUser(User user) {
		return this.userService.addUser(user);
	}
//用户账号校检
	@ResponseBody
	@RequestMapping("/checkUserCode")
	public String checkUserCode(FieldParam fieldParam) {
		return this.userService.checkUserCode(fieldParam);
	}
//用户状态
	@ResponseBody
	@RequestMapping("/lock/{rowId}/{isLock}")
	public Integer doUserLock(@PathVariable Long rowId, @PathVariable Integer isLock) {
		return this.userService.doUserLock(rowId, isLock);
	}
	@RequestMapping("/find")
	@ResponseBody
	public LayuiResult doFind(Integer page,Integer limit) {
		//查询表中的所有数据
		Integer count = userService.getCount();
		//分页查询数据
		List<User> userList =userService.findAllUser(); 
		
		return new LayuiResult("", userList, 0, count);
		
	}
}

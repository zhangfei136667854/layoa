package com.situ.layoa.util;

public class Test {

	public static void main(String[] args) {
		String userPass = "123456";
		String str = MD5Utils.encode(userPass);
		System.out.println(str);
		//当用户登录的时候
		
		//e10adc3949ba59abbe56e057f20f883e
		// admin  123456 
		// admin  e10adc3949ba59abbe56e057f20f883e
		// Map <String,String>  <"e10adc3949ba59abbe56e057f20f883e","123456">
	}

}

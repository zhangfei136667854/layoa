/**
 * @Company:中享思途   
 * @Title:MulitpartParam.java 
 * @Author:wxinpeng   
 * @Date:2020年1月3日 上午10:46:12     
 */
package com.situ.layoa.base;

import java.io.Serializable;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/** 
 * @ClassName:MulitpartParam 
 * @Description:(MulitpartParam)  
 */
public class MulitpartParam implements Serializable {

	private static final long serialVersionUID = 1L;
	private CommonsMultipartFile mulitFile;

	public CommonsMultipartFile getMulitFile() {
		return mulitFile;
	}

	public void setMulitFile(CommonsMultipartFile mulitFile) {
		this.mulitFile = mulitFile;
	}
}

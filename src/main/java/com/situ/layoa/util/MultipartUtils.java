/**
 * @Company:中享思途   
 * @Title:MultipartUtils.java 
 * @Author:wxinpeng   
 * @Date:2019年12月31日 下午1:48:22     
 */
package com.situ.layoa.util;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/** 
 * @ClassName:MultipartUtils 
 * @Description:(MultipartUtils )  
 */
public class MultipartUtils implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * @Title: writeFile 
	 * @Description:(写出文件,并返回文件的路径)
	 * @param mulipartFile
	 * @param realPath
	 * @return 文件保存的路径
	 */
	public static String writeFile(CommonsMultipartFile mulipartFile, String realPath) {
		if (mulipartFile != null) {
			//上传的文件名称
			String originalFilename = mulipartFile.getOriginalFilename();
			// 文件的后缀
			String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
			// 写出的文件地址#此路径应该写到数据库中
			String filePath = ConfigUtils.PRODUCT_BASE_PATH + Calendar.getInstance().getTimeInMillis() + suffix;
			//要写出的文件
			//E:/webfiles/reiz/filereiz/product/1577933320098.png
			File toFile = new File(realPath + filePath);
			try {
				//通过 transferTo 直接将文件写出
				mulipartFile.transferTo(toFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			return filePath;
		}
		return null;
	}
}

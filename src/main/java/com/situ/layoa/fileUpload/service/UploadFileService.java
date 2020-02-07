package com.situ.layoa.fileUpload.service;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.situ.layoa.fileUpload.domain.UploadFile;


//用来写出文件  并返回一个地址
@Service
public class UploadFileService implements UploadFileServicesss{
public String getFileImg(UploadFile uploadFile, HttpServletRequest request) {
	CommonsMultipartFile multipartFile = uploadFile.getUploadFile(); 
	String orgFileName = multipartFile.getOriginalFilename();
	//文件后缀
	String suffix = orgFileName.substring(orgFileName.indexOf("."));
	//文件相对路径:
	String filePath = "layoaFile/"+Calendar.getInstance().getTimeInMillis()+suffix;
	
	String realPath = "D:/webfiles/reiz/";
	File file = new File(realPath+filePath);
	
	try {
		multipartFile.transferTo(file);//将文件写出
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return filePath ;
	
}
}

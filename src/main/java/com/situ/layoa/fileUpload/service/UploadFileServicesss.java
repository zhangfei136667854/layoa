package com.situ.layoa.fileUpload.service;

import javax.servlet.http.HttpServletRequest;

import com.situ.layoa.fileUpload.domain.UploadFile;

public interface UploadFileServicesss {
	String getFileImg(UploadFile uploadFile, HttpServletRequest request);
}

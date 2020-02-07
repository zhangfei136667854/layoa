package com.situ.layoa.fileUpload.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Alias("Upload")
public class UploadFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CommonsMultipartFile uploadFile ;
	/**
	 * @return the uploadFile
	 */
	public CommonsMultipartFile getUploadFile() {
		return uploadFile;
	}
	/**
	 * @param uploadFile the uploadFile to set
	 */
	public void setUploadFile(CommonsMultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

}

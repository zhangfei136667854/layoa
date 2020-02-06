package com.situ.layoa.base;

import java.io.Serializable;

/**
 * 唯一校验的参数类
 * 
 * @author wxinpeng
 *
 */
public class FieldParam implements Serializable {
	private static final long serialVersionUID = 1L;
	private String fieldId;
	private String fieldValue;

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
}

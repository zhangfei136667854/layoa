package com.situ.layoa.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static String buildValidationInfo(String fieldId, Boolean bool) {
		// [String,Boolean] ["roleName",true]
		List<Object> list = new ArrayList<Object>();
		list.add(fieldId);
		list.add(bool);
		try {
			// 将封装好的校验结果转换成json格式的字符串并响应回去
			return objectMapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}

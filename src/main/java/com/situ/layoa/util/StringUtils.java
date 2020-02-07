package com.situ.layoa.util;

import java.io.Serializable;

public class StringUtils implements Serializable {
	private static final long serialVersionUID = 1L;

	private StringUtils() {
	}

	/**
	 * 检测字符串不为空
	 * 
	 * @param resource
	 */
	public static boolean isNotEmpty(String resource) {
		if (resource != null && !"".equals(resource)) {
			return true;
		}
		return false;
	}
}

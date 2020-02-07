/**
 * @Company:中享思途   
 * @Title:MyBatisUtils.java 
 * @Author:wxinpeng   
 * @Date:2020年1月12日 下午5:39:01     
 */
package com.situ.layoa.util;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName:MyBatisUtils 
 * @Description:(MyBatisUtils)  
 */
public class MyBatisUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String GET_PREFIX = "get";//get方法的前缀
	private static final String REGEX_SET_METHOD = "^set.*";
	//排除在外的 Method名称集合
	private static List<String> EXCLUDE_METHOD = new ArrayList<String>();
	static {
		EXCLUDE_METHOD.add("setRowId");
		EXCLUDE_METHOD.add("setClass");
		EXCLUDE_METHOD.add("setActiveFlag");
		EXCLUDE_METHOD.add("setCreateBy");
		EXCLUDE_METHOD.add("setCreateDate");
	}

	private MyBatisUtils() {

	}

	/**
	 * @Title: buildEditData 
	 * @Description:(通过反射机制为EditObject设置数据)
	 * @param editObj 需要修改的对象
	 * @param sourceObj 提供数据的对象
	 * @return
	 */
	public static <T> T buildEditData(T editObj, T sourceObj) {
		if (editObj != null && sourceObj != null) {
			Class<?> sourceClazz = sourceObj.getClass();
			Class<?> editClazz = editObj.getClass();
			Method[] editMethods = editClazz.getMethods();
			for (Method method : editMethods) {
				String methodName = method.getName();
				if (methodName.matches(REGEX_SET_METHOD)) {
					if (EXCLUDE_METHOD.contains(methodName)) {
						continue;
					}
					try {
						//get方法名称
						String getMethodName = GET_PREFIX + methodName.substring(3);
						//get方法对象
						Method sourceMethod = sourceClazz.getMethod(getMethodName);
						method.invoke(editObj, sourceMethod.invoke(sourceObj));
					} catch (NoSuchMethodException e) {
						//e.printStackTrace();
						throw new RuntimeException(e);
					} catch (IllegalArgumentException e) {
						//e.printStackTrace();
						throw new RuntimeException(e);
					} catch (IllegalAccessException e) {
						//e.printStackTrace();
						throw new RuntimeException(e);
					} catch (InvocationTargetException e) {
						//e.printStackTrace();
						throw new RuntimeException(e);
					}
				}
			}
		}
		return editObj;
	}
}

package com.situ.layoa.commons;

import java.io.Serializable;

public class LayuiResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg ; 
	private Object data ; 
	private Integer code ;
	private Integer count ; //数据
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	public LayuiResult(String msg, Object data, Integer code) {
		super();
		this.msg = msg;
		this.data = data;
		this.code = code;
	}
	public LayuiResult() {
		super();
	}
	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	public LayuiResult(String msg, Object data, Integer code, Integer count) {
		super();
		this.msg = msg;
		this.data = data;
		this.code = code;
		this.count = count;
	} 
	

}

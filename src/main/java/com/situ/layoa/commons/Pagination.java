package com.situ.layoa.commons;

import java.io.Serializable;

public class Pagination implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer firstResult ;//分页开始的下坐标
	private Integer maxResult ; //分页查询的数量
	/**
	 * @return the firstResult
	 */
	public Integer getFirstResult() {
		return firstResult;
	}
	/**
	 * @param firstResult the firstResult to set
	 */
	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}
	/**
	 * @return the maxResult
	 */
	public Integer getMaxResult() {
		return maxResult;
	}
	/**
	 * @param maxResult the maxResult to set
	 */
	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}
	public Pagination(Integer firstResult, Integer maxResult) {
		super();
		this.firstResult = firstResult;
		this.maxResult = maxResult;
	}
	
	
	

}

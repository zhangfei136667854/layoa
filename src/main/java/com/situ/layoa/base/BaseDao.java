package com.situ.layoa.base;

import java.util.List;

/**
 * @DAO的基本接口
 * @author wxinpeng
 *
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 保存对象
	 * 
	 * @param t
	 * @return
	 */
	Long save(T t);

	/**
	 * 修改对象
	 * 
	 * @param t
	 */
	void update(T t);

	/**
	 * 删除对象
	 * 
	 * @param rowId
	 */
	void delete(Long rowId);

	/**
	 * 根据ID查询对象
	 * 
	 * @param rowId
	 * @return
	 */
	T get(Long rowId);

	/**
	 * 查询所有的记录
	 * 
	 * @return
	 */
	List<T> find();
}

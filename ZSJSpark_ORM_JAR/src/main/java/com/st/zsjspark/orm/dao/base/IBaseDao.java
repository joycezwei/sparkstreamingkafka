package com.st.zsjspark.orm.dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 基础的Dao接口 泛型类
 * 
 * @author Wlq
 * @param <T>
 */
public interface IBaseDao<T> {
	/**
	 * 计数，用于分页
	 * 
	 * @return
	 */
	public int count(Map map);

	/**
	 * 带条件查询（条件可以为null）返回list对象集合
	 * 
	 * @param map
	 * @return
	 */
	public List<T> findByCondition(Map map);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);

	/**
	 * 插入，用实体作为参数
	 * 
	 * @param entity
	 */
	public int insert(T entity);

	/**
	 * 修改，用实体作为参数
	 * 
	 * @param entity
	 */
	public int update(T entity);

	/**
	 * 批量删除；支持整数型和字符串类型ID
	 * 
	 * @param ids
	 */
	public int delete(Serializable[] ids);

}

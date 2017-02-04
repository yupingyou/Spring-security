package com.xingguo.service.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.xingguo.entity.common.PaginationSupport;

public interface BaseService<T> {
	/**
	 * 通用方法：保存瞬时对象
	 * @param entity
	 */
	public void save(T entity);
	/**
	 * 通用方法： 更新持久化对象
	 * @param entity
	 */
	public void update(T entity);
	/**
	 * 通用方法： 删除持久化对象
	 * @param entity
	 */
	public void delete(T entity);
	/**
	 * 通用方法： 根据ID查询单个实体
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);
	/**
	 * 通用方法： Hibernate分页查询
	 * @param map 查询条件
	 * @param pageIndex 当前页
	 * @param pageSize 每页条数
	 * @param orders 排序字段（ 可选）格式：key（字段名），value（desc 或 asc 或null）
	 * @return 
	 */
	public PaginationSupport<T> findByPageWithCondition(Map<String, Object> map,int pageIndex,int pageSize,Map<String,String> orders);
	/**
	 * 通用方法： 根据查询条件查找单一的实体
	 * @param map
	 * @return
	 */
	public T findEntityByCondition(Map<String, Object> map);
	/**
	 * 通用方法： 根据查询条件查询列表
	 * @param map
	 * @param orders 排序字段（ 可选）格式：key（字段名），value（desc 或 asc 或null）
	 * @return
	 */
	public List<T> findListByCondition(Map<String, Object> map, Map<String,String> orders);
	/**
	 * 公用方法：批量删除；物理删，不可恢复
	 * @param ids
	 */
	public void batchDelete(String[] ids);
	/**
	 * 批量更新持久化对象
	 * @param presisEntity
	 */
	public void batchUpdate(List<T> presisEntity);
	
}

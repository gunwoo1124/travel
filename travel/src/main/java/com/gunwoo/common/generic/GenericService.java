package com.gunwoo.common.generic;

import com.gunwoo.common.paging.PagingData;

import java.util.List;
import java.util.Map;

public interface GenericService<T>
{
	boolean insert(T entity);
	T select(Integer index);
	List<T> selectAll();
	List<T> selectBySearch(Map<String, Object> parameter);
	PagingData selectPagingBySearch(Map<String, Object> parameter);
	boolean update(T entity);
	boolean delete(Integer index);
}

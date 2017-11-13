package com.jefflee.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<E, K> {

	public int delete(String statement, K key) throws Exception;

	public int insert(String statement, E entity) throws Exception;

	public List<E> selectList(String statement, K key) throws Exception;

	public Map<String, E> selectMap(String statement, K key, String mapKey) throws Exception;

	public E selectOne(String statement, K key) throws Exception;

	public int update(String statement, E entity) throws Exception;

}

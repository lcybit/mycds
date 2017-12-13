package com.jefflee.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.jefflee.dao.BaseDao;

@Repository("baseDao")
public class BaseDaoImpl<E, K> implements BaseDao<E, K> {

	@Resource(name = "sqlSessionTemplate")
	protected SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int delete(String statement, K parameter) throws Exception {
		return sqlSessionTemplate.delete(statement, parameter);
	}

	@Override
	public int insert(String statement, E parameter) throws Exception {
		return sqlSessionTemplate.insert(statement, parameter);
	}

	@Override
	public List<E> selectList(String statement, K parameter) throws Exception {
		return sqlSessionTemplate.selectList(statement, parameter);
	}

	@Override
	public Map<String, E> selectMap(String statement, K parameter, String mapKey) throws Exception {
		return sqlSessionTemplate.selectMap(statement, parameter, mapKey);
	}

	@Override
	public E selectOne(String statement, K parameter) throws Exception {
		return sqlSessionTemplate.selectOne(statement, parameter);
	}

	@Override
	public int update(String statement, E parameter) throws Exception {
		return sqlSessionTemplate.update(statement, parameter);
	}

}

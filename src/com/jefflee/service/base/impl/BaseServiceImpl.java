package com.jefflee.service.base.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jefflee.dao.BaseDao;
import com.jefflee.service.base.BaseService;

@Service("baseService")
public class BaseServiceImpl<D, E, K> implements BaseService<D, K> {

	@Resource(name = "baseDao")
	protected BaseDao<E, K> baseDao;

	protected String mapperName;

}

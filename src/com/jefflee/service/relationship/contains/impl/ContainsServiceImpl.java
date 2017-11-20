package com.jefflee.service.relationship.contains.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jefflee.dto.ContainsDto;
import com.jefflee.entity.Contains;
import com.jefflee.service.base.impl.BaseServiceImpl;
import com.jefflee.service.relationship.contains.ContainsService;
import com.jefflee.util.BeanUtil;
import com.jefflee.util.DatabaseUtil;

@Service("containsService")
public class ContainsServiceImpl extends BaseServiceImpl<ContainsDto, Contains, String> implements ContainsService {

	public ContainsServiceImpl() {
		mapperName = "ContainsMapper";
	}

	@Override
	public ContainsDto create(ContainsDto containsDto) throws Exception {
		String containsId = DatabaseUtil.gnr32Uuid();
		Contains contains = new Contains();
		BeanUtil.copyProperties(containsDto, contains);
		contains.setContainsId(containsId);
		if (1 == baseDao.insert(mapperName + ".insert", contains)) {
			BeanUtil.copyProperties(contains, containsDto);
			return containsDto;
		}
		return null;
	}

	@Override
	public List<ContainsDto> findListByParentId(String parentId) throws Exception {
		List<Contains> containsList = baseDao.selectList(mapperName + ".selectListByParentId", parentId);
		List<ContainsDto> containsDtoList = new ArrayList<ContainsDto>();
		for (Contains contains : containsList) {
			ContainsDto containsDto = new ContainsDto();
			BeanUtil.copyProperties(contains, containsDto);
			containsDtoList.add(containsDto);
		}
		return containsDtoList;
	}

	@Override
	public int findMaxChildNo(String parentId) throws Exception {
		List<Contains> containsList = baseDao.selectList(mapperName + ".selectListByParentId", parentId);
		int maxChildNo = -1;
		for (Contains contains : containsList) {
			int childNo = contains.getChildNo();
			maxChildNo = childNo > maxChildNo ? childNo : maxChildNo;
		}
		return maxChildNo;
	}

}

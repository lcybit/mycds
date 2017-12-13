package com.jefflee.service.relationship.contains;

import java.util.List;

import com.jefflee.dto.ContainsDto;
import com.jefflee.service.base.BaseService;

public interface ContainsService extends BaseService<ContainsDto, String> {

	public ContainsDto create(ContainsDto containsDto) throws Exception;

	public List<ContainsDto> findListByParentId(String componentId) throws Exception;

	int findMaxChildNo(String parentId) throws Exception;

}

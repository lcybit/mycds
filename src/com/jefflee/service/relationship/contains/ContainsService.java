package com.jefflee.service.relationship.contains;

import java.util.List;

import com.jefflee.dto.ContainsDto;
import com.jefflee.service.base.BaseService;

public interface ContainsService extends BaseService<ContainsDto, String> {

	public List<ContainsDto> findListByParentId(String componentId) throws Exception;

	public ContainsDto create(ContainsDto containsDto) throws Exception;

}

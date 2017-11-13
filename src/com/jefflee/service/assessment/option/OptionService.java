package com.jefflee.service.assessment.option;

import java.util.List;

import com.jefflee.dto.OptionDto;
import com.jefflee.service.base.BaseService;

public interface OptionService extends BaseService<OptionDto, String> {

	public OptionDto create(OptionDto optionDto) throws Exception;

	public OptionDto findDetailById(String optionId) throws Exception;

	public OptionDto findById(String optionId) throws Exception;

	public List<OptionDto> findListByParentId(String parentId) throws Exception;

}

package com.jefflee.service.assessment.option;

import java.util.List;

import com.jefflee.dto.OptionDto;
import com.jefflee.service.base.BaseService;

public interface OptionService extends BaseService<OptionDto, String> {

	OptionDto create(OptionDto optionDto) throws Exception;

	OptionDto findById(String optionId) throws Exception;

	OptionDto findDetailById(String optionId) throws Exception;

	List<OptionDto> findListByParentId(String parentId) throws Exception;

	OptionDto modify(OptionDto optionDto) throws Exception;

}

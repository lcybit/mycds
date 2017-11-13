package com.jefflee.service.assessment.option.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jefflee.dto.ContainsDto;
import com.jefflee.dto.OptionDto;
import com.jefflee.entity.Option;
import com.jefflee.service.assessment.option.OptionService;
import com.jefflee.service.assessment.question.QuestionService;
import com.jefflee.service.base.impl.BaseServiceImpl;
import com.jefflee.service.relationship.contains.ContainsService;
import com.jefflee.util.BeanUtil;
import com.jefflee.util.DatabaseUtil;

@Service("optionService")
public class OptionServiceImpl extends BaseServiceImpl<OptionDto, Option, String> implements OptionService {

	@Resource(name = "questionService")
	private QuestionService questionService;
	@Resource(name = "containsService")
	private ContainsService containsService;

	public OptionServiceImpl() {
		mapperName = "OptionMapper";
	}

	@Override
	public OptionDto create(OptionDto optionDto) throws Exception {
		// Insert parent group relationship
		ContainsDto parentContainsDto = new ContainsDto();
		String optionId = DatabaseUtil.gnr32Uuid();
		parentContainsDto.setParentId(optionDto.getQuestionId());
		parentContainsDto.setChildId(optionId);
		parentContainsDto.setChildNo(0);
		ContainsDto parentContains = containsService.create(parentContainsDto);
		if (null == parentContains) {
			return null;
		}
		// Insert option
		Option option = new Option();
		BeanUtil.copyProperties(optionDto, option);
		option.setOptionId(optionId);
		option.setStatus("created");
		if (1 == baseDao.insert(mapperName + ".insert", option)) {
			BeanUtil.copyPropertiesIgnoreNull(option, optionDto);
			return optionDto;
		}
		return null;
	}

	@Override
	public OptionDto findDetailById(String optionId) throws Exception {
		return findById(optionId);
	}

	@Override
	public OptionDto findById(String optionId) throws Exception {
		Option option = baseDao.selectOne(mapperName + ".selectOne", optionId);
		OptionDto optionDto = new OptionDto();
		BeanUtil.copyProperties(option, optionDto);
		return optionDto;
	}

	@Override
	public List<OptionDto> findListByParentId(String parentId) throws Exception {
		List<ContainsDto> parentContainsDtoList = containsService.findListByParentId(parentId);
		List<OptionDto> optionDtoList = new ArrayList<OptionDto>();
		for (ContainsDto parentContainsDto : parentContainsDtoList) {
			optionDtoList.add(findById(parentContainsDto.getChildId()));
		}
		return optionDtoList;
	}

}

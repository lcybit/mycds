package com.jefflee.service.assessment.question.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jefflee.dto.ContainsDto;
import com.jefflee.dto.OptionDto;
import com.jefflee.dto.QuestionDto;
import com.jefflee.entity.Question;
import com.jefflee.service.assessment.option.OptionService;
import com.jefflee.service.assessment.question.QuestionService;
import com.jefflee.service.base.impl.BaseServiceImpl;
import com.jefflee.service.relationship.contains.ContainsService;
import com.jefflee.util.BeanUtil;
import com.jefflee.util.DatabaseUtil;

@Service("questionService")
public class QuestionServiceImpl extends BaseServiceImpl<QuestionDto, Question, String> implements QuestionService {

	@Resource(name = "optionService")
	private OptionService optionService;
	@Resource(name = "containsService")
	private ContainsService containsService;

	public QuestionServiceImpl() {
		mapperName = "QuestionMapper";
	}

	@Override
	public QuestionDto create(QuestionDto questionDto) throws Exception {
		// Create parent group relationship
		ContainsDto parentContainsDto = new ContainsDto();
		String questionId = DatabaseUtil.gnr32Uuid();
		String questionnaireId = questionDto.getQuestionnaireId();
		parentContainsDto.setParentId(questionnaireId);
		parentContainsDto.setChildId(questionId);
		parentContainsDto.setChildNo(containsService.findMaxChildNo(questionnaireId) + 1);
		parentContainsDto = containsService.create(parentContainsDto);
		if (null == parentContainsDto) {
			return null;
		}
		// Create question
		Question question = new Question();
		BeanUtil.copyProperties(questionDto, question);
		question.setQuestionId(questionId);
		question.setStatus("created");
		if (1 == baseDao.insert(mapperName + ".insert", question)) {
			BeanUtil.copyPropertiesIgnoreNull(question, questionDto);
			return questionDto;
		}
		return null;
	}

	@Override
	public QuestionDto findById(String questionId) throws Exception {
		Question question = baseDao.selectOne(mapperName + ".selectOne", questionId);
		QuestionDto questionDto = new QuestionDto();
		BeanUtil.copyProperties(question, questionDto);
		return questionDto;
	}

	@Override
	public QuestionDto findDetailById(String questionId) throws Exception {
		QuestionDto questionDto = findById(questionId);
		List<OptionDto> optionDtoList = new ArrayList<OptionDto>();
		List<ContainsDto> containsDtoList = containsService.findListByParentId(questionId);
		for (ContainsDto containsDto : containsDtoList) {
			optionDtoList.add(optionService.findDetailById(containsDto.getChildId()));
		}
		questionDto.setOptionList(optionDtoList);
		return questionDto;
	}

	@Override
	public List<QuestionDto> findListByParentId(String parentId) throws Exception {
		List<ContainsDto> parentContainsDtoList = containsService.findListByParentId(parentId);
		List<QuestionDto> questionDtoList = new ArrayList<QuestionDto>();
		for (ContainsDto parentContainsDto : parentContainsDtoList) {
			questionDtoList.add(findById(parentContainsDto.getChildId()));
		}
		return questionDtoList;
	}

	@Override
	public QuestionDto modify(QuestionDto questionDto) throws Exception {
		Question question = baseDao.selectOne(mapperName + ".selectOne", questionDto.getQuestionId());
		BeanUtil.copyPropertiesIgnoreNull(questionDto, question);
		if (1 == baseDao.update(mapperName + ".update", question)) {
			return questionDto;
		}
		return null;
	}

}

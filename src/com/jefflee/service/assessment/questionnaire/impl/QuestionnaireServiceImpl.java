package com.jefflee.service.assessment.questionnaire.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jefflee.dto.ContainsDto;
import com.jefflee.dto.QuestionDto;
import com.jefflee.dto.QuestionnaireDto;
import com.jefflee.entity.Questionnaire;
import com.jefflee.service.assessment.question.QuestionService;
import com.jefflee.service.assessment.questionnaire.QuestionnaireService;
import com.jefflee.service.base.impl.BaseServiceImpl;
import com.jefflee.service.relationship.contains.ContainsService;
import com.jefflee.util.BeanUtil;
import com.jefflee.util.DatabaseUtil;

@Service("questionnaireService")
public class QuestionnaireServiceImpl extends BaseServiceImpl<QuestionnaireDto, Questionnaire, String>
		implements QuestionnaireService {

	@Resource(name = "questionService")
	private QuestionService questionService;
	@Resource(name = "containsService")
	private ContainsService containsService;

	public QuestionnaireServiceImpl() {
		mapperName = "QuestionnaireMapper";
	}

	@Override
	public QuestionnaireDto create(QuestionnaireDto questionnaireDto) throws Exception {
		Questionnaire questionnaire = new Questionnaire();
		BeanUtil.copyProperties(questionnaireDto, questionnaire);
		String questionnaireId = DatabaseUtil.gnr32Uuid();
		questionnaire.setQuestionnaireId(questionnaireId);
		questionnaire.setStyle("normal");
		questionnaire.setStatus("created");
		if (1 == baseDao.insert(mapperName + ".insert", questionnaire)) {
			BeanUtil.copyPropertiesIgnoreNull(questionnaire, questionnaireDto);
			return questionnaireDto;
		}
		return null;
	}

	@Override
	public QuestionnaireDto findById(String questionnaireId) throws Exception {
		Questionnaire questionnaire = baseDao.selectOne(mapperName + ".selectOne", questionnaireId);
		QuestionnaireDto questionnaireDto = new QuestionnaireDto();
		BeanUtil.copyProperties(questionnaire, questionnaireDto);
		return questionnaireDto;
	}

	@Override
	public QuestionnaireDto findDetailById(String questionnaireId) throws Exception {
		QuestionnaireDto questionnaireDto = findById(questionnaireId);
		List<QuestionDto> questionDtoList = new ArrayList<QuestionDto>();
		List<ContainsDto> containsDtoList = containsService.findListByParentId(questionnaireId);
		for (ContainsDto containsDto : containsDtoList) {
			questionDtoList.add(questionService.findDetailById(containsDto.getChildId()));
		}
		questionnaireDto.setQuestionList(questionDtoList);
		return questionnaireDto;
	}

	@Override
	public List<QuestionnaireDto> findList() throws Exception {
		List<Questionnaire> questionnaireList = baseDao.selectList(mapperName + ".selectList", null);
		List<QuestionnaireDto> questionnaireDtoList = new ArrayList<QuestionnaireDto>();
		for (Questionnaire questionnaire : questionnaireList) {
			QuestionnaireDto questionnaireDto = new QuestionnaireDto();
			BeanUtil.copyProperties(questionnaire, questionnaireDto);
			questionnaireDtoList.add(questionnaireDto);
		}
		return questionnaireDtoList;
	}

	@Override
	public QuestionnaireDto modify(QuestionnaireDto questionnaireDto) throws Exception {
		Questionnaire questionnaire = new Questionnaire();
		BeanUtil.copyPropertiesIgnoreNull(questionnaireDto, questionnaire);
		if (1 == baseDao.update(mapperName + ".update", questionnaire)) {
			return questionnaireDto;
		}
		return null;
	}

}

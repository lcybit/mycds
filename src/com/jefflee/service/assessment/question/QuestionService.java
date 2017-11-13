package com.jefflee.service.assessment.question;

import java.util.List;

import com.jefflee.dto.QuestionDto;
import com.jefflee.service.base.BaseService;

public interface QuestionService extends BaseService<QuestionDto, String> {

	public QuestionDto create(QuestionDto questionDto) throws Exception;

	public QuestionDto findDetailById(String questionId) throws Exception;

	public QuestionDto findById(String questionId) throws Exception;

	public List<QuestionDto> findListByParentId(String parentId) throws Exception;

}

package com.jefflee.service.assessment.question;

import java.util.List;

import com.jefflee.dto.QuestionDto;
import com.jefflee.service.base.BaseService;

public interface QuestionService extends BaseService<QuestionDto, String> {

	QuestionDto create(QuestionDto questionDto) throws Exception;

	QuestionDto findById(String questionId) throws Exception;

	QuestionDto findDetailById(String questionId) throws Exception;

	List<QuestionDto> findListByParentId(String parentId) throws Exception;

	QuestionDto modify(QuestionDto questionDto) throws Exception;

}

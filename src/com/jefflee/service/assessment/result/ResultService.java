package com.jefflee.service.assessment.result;

import java.util.List;
import java.util.Map;

import com.jefflee.dto.ResultDto;
import com.jefflee.service.base.BaseService;

public interface ResultService extends BaseService<ResultDto, String> {

	ResultDto create(ResultDto resultDto) throws Exception;

	ResultDto findById(String resultId) throws Exception;

	List<ResultDto> findList() throws Exception;

	List<ResultDto> findListBySessionId(String sessionId) throws Exception;

	Map<String, Object> assess(String resultId) throws Exception;

	List<ResultDto> findListByQuestionnaireId(String questionnaireId) throws Exception;

}
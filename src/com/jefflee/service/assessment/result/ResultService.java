package com.jefflee.service.assessment.result;

import java.util.List;
import java.util.Map;

import com.jefflee.dto.ResultDto;
import com.jefflee.service.base.BaseService;

public interface ResultService extends BaseService<ResultDto, String> {

	Map<String, Object> assess(String resultId) throws Exception;

	ResultDto create(ResultDto resultDto) throws Exception;

	ResultDto findById(String resultId) throws Exception;

	List<ResultDto> findList() throws Exception;

	List<ResultDto> findListByQuestionnaireId(String questionnaireId) throws Exception;

	List<ResultDto> findListBySessionId(String sessionId) throws Exception;

	ResultDto modify(ResultDto resultDto) throws Exception;

}
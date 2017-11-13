package com.jefflee.service.assessment.result;

import java.util.List;
import java.util.Map;

import com.jefflee.dto.ResultDto;
import com.jefflee.service.base.BaseService;

public interface ResultService extends BaseService<ResultDto, String> {

	public ResultDto create(ResultDto resultDto) throws Exception;

	public ResultDto findById(String resultId) throws Exception;

	public List<ResultDto> findList() throws Exception;

	List<ResultDto> findListBySessionId(String sessionId) throws Exception;

	Map<String, Object> assess(String resultId) throws Exception;

}
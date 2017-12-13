package com.jefflee.service.screening;

import java.util.List;

import com.jefflee.dto.TestDto;
import com.jefflee.service.base.BaseService;

public interface TestService extends BaseService<TestDto, String> {

	TestDto create(TestDto testDto) throws Exception;

	TestDto findById(String testId) throws Exception;

	List<TestDto> findList() throws Exception;

	List<TestDto> findRecommondedList(String resultId) throws Exception;

	TestDto modify(TestDto testDto) throws Exception;

}

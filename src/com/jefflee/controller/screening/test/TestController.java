package com.jefflee.controller.screening.test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jefflee.dto.TestDto;
import com.jefflee.service.screening.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Resource(name = "testService")
	private TestService testService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public TestDto create(@RequestBody TestDto testDto) throws Exception {
		testDto = testService.create(testDto);
		return testDto;
	}

	@RequestMapping(value = "/find/{testId}", method = RequestMethod.GET)
	public TestDto find(@PathVariable("testId") String testId) throws Exception {
		TestDto testDto = testService.findById(testId);
		return testDto;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TestDto> list() throws Exception {
		List<TestDto> testDtoList = testService.findList();
		return testDtoList;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public TestDto modify(@RequestBody TestDto testDto) throws Exception {
		testDto = testService.modify(testDto);
		return testDto;
	}

}
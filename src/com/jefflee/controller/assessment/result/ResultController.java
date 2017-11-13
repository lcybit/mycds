package com.jefflee.controller.assessment.result;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jefflee.dto.ResultDto;
import com.jefflee.service.assessment.result.ResultService;

@RestController
@RequestMapping("/result")
public class ResultController {

	@Resource(name = "resultService")
	private ResultService resultService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResultDto create(@RequestBody ResultDto resultDto) throws Exception {
		resultDto = resultService.create(resultDto);
		return resultDto;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<ResultDto> list() throws Exception {
		List<ResultDto> resultDtoList = resultService.findList();
		return resultDtoList;
	}

	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public List<ResultDto> list(@PathVariable("id") String sessionId) throws Exception {
		List<ResultDto> resultDtoList = resultService.findListBySessionId(sessionId);
		return resultDtoList;
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public ResultDto find(@PathVariable("id") String resultId) throws Exception {
		ResultDto resultDto = resultService.findById(resultId);
		return resultDto;
	}

	@RequestMapping(value = "/assess/{id}", method = RequestMethod.GET)
	public Map<String, Object> assess(@PathVariable("id") String resultId) throws Exception {
		Map<String, Object> result = resultService.assess(resultId);
		return result;
	}

}
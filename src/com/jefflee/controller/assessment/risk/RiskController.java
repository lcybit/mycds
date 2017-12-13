package com.jefflee.controller.assessment.risk;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jefflee.dto.RiskDto;
import com.jefflee.service.assessment.risk.RiskService;

@RestController
@RequestMapping("/risk")
public class RiskController {

	@Resource(name = "riskService")
	private RiskService riskService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public RiskDto create(@RequestBody RiskDto riskDto) throws Exception {
		riskDto = riskService.create(riskDto);
		return riskDto;
	}

	@RequestMapping(value = "/find/{riskId}", method = RequestMethod.GET)
	public RiskDto find(@PathVariable("riskId") String riskId) throws Exception {
		RiskDto riskDto = riskService.findById(riskId);
		return riskDto;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<RiskDto> list() throws Exception {
		List<RiskDto> riskDtoList = riskService.findList();
		return riskDtoList;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public RiskDto modify(@RequestBody RiskDto riskDto) throws Exception {
		riskDto = riskService.modify(riskDto);
		return riskDto;
	}

}
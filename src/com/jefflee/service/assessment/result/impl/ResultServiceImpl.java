package com.jefflee.service.assessment.result.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jefflee.dto.ResultDto;
import com.jefflee.dto.RiskDto;
import com.jefflee.dto.TestDto;
import com.jefflee.entity.Result;
import com.jefflee.service.assessment.result.ResultService;
import com.jefflee.service.assessment.risk.RiskService;
import com.jefflee.service.base.impl.BaseServiceImpl;
import com.jefflee.service.screening.TestService;
import com.jefflee.util.BeanUtil;
import com.jefflee.util.DatabaseUtil;
import com.jefflee.util.NumberUtil;

@Service("resultService")
public class ResultServiceImpl extends BaseServiceImpl<ResultDto, Result, String> implements ResultService {

	@Resource(name = "testService")
	private TestService testService;
	@Resource(name = "riskService")
	private RiskService riskService;

	public ResultServiceImpl() {
		mapperName = "ResultMapper";
	}

	@Override
	public Map<String, Object> assess(String resultId) throws Exception {
		ResultDto resultDto = findById(resultId);
		String questionnaireId = resultDto.getQuestionnaireId();
		List<ResultDto> resultDtoList = findListByQuestionnaireId(questionnaireId);
		Map<String, Object> assessResult = new HashMap<String, Object>();
		Map<String, Double> riskData = option2Data(resultDto);
		assessResult.put("riskData", riskData);
		Map<String, Double> avgRiskData = average(resultDtoList);
		assessResult.put("avgRiskData", avgRiskData);
		assessResult.put("total", total(riskData));
		assessResult.put("avgTotal", total(avgRiskData));
		List<TestDto> recommondedTestDtoList = testService.findRecommondedList(resultId);
		assessResult.put("recommondedTestList", recommondedTestDtoList);
		return assessResult;
	}

	private Map<String, Double> average(List<ResultDto> resultDtoList) throws Exception {
		Map<String, Double> avgRiskData = option2Data(resultDtoList.get(0));
		for (int i = 1; i < resultDtoList.size(); i++) {
			ResultDto resultDto = resultDtoList.get(i);
			Map<String, Double> riskData = option2Data(resultDto);
			for (String riskDto : riskData.keySet()) {
				avgRiskData.put(riskDto, (riskData.get(riskDto) + i * avgRiskData.get(riskDto)) / (i + 1));
			}
		}
		for (String riskDto : avgRiskData.keySet()) {
			avgRiskData.put(riskDto, NumberUtil.reserveTwo(avgRiskData.get(riskDto)));
		}
		return avgRiskData;
	}

	@Override
	public ResultDto create(ResultDto resultDto) throws Exception {
		Result result = new Result();
		BeanUtil.copyProperties(resultDto, result);
		String resultId = DatabaseUtil.gnr32Uuid();
		result.setResultId(resultId);
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
				.getSession();
		result.setSessionId(session.getId());
		if (1 == baseDao.insert(mapperName + ".insert", result)) {
			BeanUtil.copyPropertiesIgnoreNull(result, resultDto);
			return resultDto;
		}
		return null;
	}

	@Override
	public ResultDto findById(String resultId) throws Exception {
		Result result = baseDao.selectOne(mapperName + ".selectOne", resultId);
		ResultDto resultDto = new ResultDto();
		BeanUtil.copyProperties(result, resultDto);
		return resultDto;
	}

	@Override
	public List<ResultDto> findList() throws Exception {
		List<Result> resultList = baseDao.selectList(mapperName + ".selectList", null);
		List<ResultDto> resultDtoList = new ArrayList<ResultDto>();
		for (Result result : resultList) {
			ResultDto resultDto = new ResultDto();
			BeanUtil.copyProperties(result, resultDto);
			resultDtoList.add(resultDto);
		}
		return resultDtoList;
	}

	@Override
	public List<ResultDto> findListByQuestionnaireId(String questionnaireId) throws Exception {
		List<Result> resultList = baseDao.selectList(mapperName + ".selectListByQuestionnaireId", questionnaireId);
		List<ResultDto> resultDtoList = new ArrayList<ResultDto>();
		for (Result result : resultList) {
			ResultDto resultDto = new ResultDto();
			BeanUtil.copyProperties(result, resultDto);
			resultDtoList.add(resultDto);
		}
		return resultDtoList;
	}

	@Override
	public List<ResultDto> findListBySessionId(String sessionId) throws Exception {
		List<Result> resultList = baseDao.selectList(mapperName + ".selectListBySessionId", sessionId);
		List<ResultDto> resultDtoList = new ArrayList<ResultDto>();
		for (Result result : resultList) {
			ResultDto resultDto = new ResultDto();
			BeanUtil.copyProperties(result, resultDto);
			resultDtoList.add(resultDto);
		}
		return resultDtoList;
	}

	@Override
	public ResultDto modify(ResultDto resultDto) throws Exception {
		Result result = new Result();
		BeanUtil.copyPropertiesIgnoreNull(resultDto, result);
		if (1 == baseDao.update(mapperName + ".update", result)) {
			return resultDto;
		}
		return null;
	}

	private Map<String, Double> option2Data(ResultDto resultDto) throws Exception {
		List<RiskDto> riskDtoList = riskService.findList();
		Map<String, Double> riskData = new LinkedHashMap<String, Double>();
		for (RiskDto riskDto : riskDtoList) {
			String riskName = riskDto.getName();
			Double riskValue = 1.0;
			switch (riskName) {
			case "FamilyHistory":
				riskValue = resultDto.getQ0() <= 1 ? (resultDto.getQ0() < 1 ? 1.0 : 2.2) : 4.0;
				break;
			case "InflammatoryBowelDisease":
				riskValue = resultDto.getQ1() == 1 ? 1.7 : 1.0;
				break;
			case "Diabetes":
				riskValue = resultDto.getQ2() == 1 ? 1.3 : 1.0;
				break;
			case "AlcoholConsumption":
				riskValue = resultDto.getQ3() == 0 ? 1.0 : (resultDto.getQ3() == 1 ? 1.2 : 1.4);
				break;
			case "Obesity":
				riskValue = resultDto.getQ4() == 1 ? 1.3 : 1.0;
				break;
			case "RedMeatConsumption":
				riskValue = resultDto.getQ5() == 1 ? 1.2 : 1.0;
				break;
			case "ProcessedMeatConsumption":
				riskValue = resultDto.getQ6() == 1 ? 1.2 : 1.0;
				break;
			case "Smoking":
				riskValue = resultDto.getQ7() == 1 ? 1.2 : 1.0;
				break;
			case "PhysicalActivity":
				riskValue = resultDto.getQ8() == 1 ? 0.7 : 1.0;
				break;
			case "DairyConsumption":
				riskValue = resultDto.getQ9() == 1 ? 0.8 : 1.0;
				break;
			case "MilkConsumption":
				riskValue = resultDto.getQ10() == 1 ? 0.9 : 1.0;
				break;
			default:
				riskValue = 1.0;
				break;
			}
			riskData.put(riskName, NumberUtil.reserveTwo(Math.log(riskValue)));
		}

		return riskData;
	}

	private Double total(Map<String, Double> riskData) {
		Double totalRisk = 0.0;
		for (Double riskValue : riskData.values()) {
			totalRisk += riskValue;
		}
		return NumberUtil.reserveTwo(totalRisk);
	}

}

package com.jefflee.service.assessment.result.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jefflee.dto.ResultDto;
import com.jefflee.entity.Result;
import com.jefflee.service.assessment.question.QuestionService;
import com.jefflee.service.assessment.result.ResultService;
import com.jefflee.service.base.impl.BaseServiceImpl;
import com.jefflee.service.relationship.contains.ContainsService;
import com.jefflee.util.BeanUtil;
import com.jefflee.util.DatabaseUtil;

@Service("resultService")
public class ResultServiceImpl extends BaseServiceImpl<ResultDto, Result, String> implements ResultService {

	@Resource(name = "questionService")
	private QuestionService questionService;
	@Resource(name = "containsService")
	private ContainsService containsService;

	public ResultServiceImpl() {
		mapperName = "ResultMapper";
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
	public ResultDto findById(String resultId) throws Exception {
		Result result = baseDao.selectOne(mapperName + ".selectOne", resultId);
		ResultDto resultDto = new ResultDto();
		BeanUtil.copyProperties(result, resultDto);
		return resultDto;
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
	public Map<String, Object> assess(String resultId) throws Exception {
		ResultDto resultDto = findById(resultId);
		Map<String, Object> assessResult = new HashMap<String, Object>();
		Map<String, Double> riskData = option2Data(resultDto);
		assessResult.put("riskData", riskData);
		assessResult.put("totalRisk", calculate(riskData));
		return assessResult;
	}

	private Double calculate(Map<String, Double> riskData) {
		Double totalRisk = 0.0;
		for (Double riskValue : riskData.values()) {
			totalRisk += riskValue;
		}
		return totalRisk;
	}

	private Map<String, Double> option2Data(ResultDto resultDto) {
		int familyHistory = resultDto.getQ0();
		int inflammatoryBowelDisease = resultDto.getQ1();
		int diabetes = resultDto.getQ2();
		int alcoholConsumption = resultDto.getQ3();
		int obesity = resultDto.getQ4();
		int redMeatConsumption = resultDto.getQ5();
		int processedMeatConsumption = resultDto.getQ6();
		int smoking = resultDto.getQ7();
		int physicalActivity = resultDto.getQ8();
		int dairyConsumption = resultDto.getQ9();
		int milkConsumption = resultDto.getQ10();

		Double familyHistoryRisk = 1.0;
		try {
			familyHistoryRisk = familyHistory <= 1 ? (familyHistory < 1 ? 1.0 : 2.2) : 4.0;
		} catch (NumberFormatException e) {
			familyHistoryRisk = 1.0;
		}
		Double inflammatoryBowelDiseaseRisk = inflammatoryBowelDisease == 1 ? 1.7 : 1.0;
		Double diabetesRisk = diabetes == 1 ? 1.3 : 1.0;
		Double alcoholConsumptionRisk = alcoholConsumption == 0 ? 1.0 : (alcoholConsumption == 1 ? 1.2 : 1.4);
		Double obesityRisk = obesity == 1 ? 1.3 : 1.0;
		Double redMeatConsumptionRisk = redMeatConsumption == 1 ? 1.2 : 1.0;
		Double processedMeatConsumptionRisk = processedMeatConsumption == 1 ? 1.2 : 1.0;
		Double smokingRisk = smoking == 1 ? 1.2 : 1.0;
		Double physicalActivityRisk = physicalActivity == 1 ? 0.7 : 1.0;
		Double dairyConsumptionRisk = dairyConsumption == 1 ? 0.8 : 1.0;
		Double milkConsumptionRisk = milkConsumption == 1 ? 0.9 : 1.0;

		Map<String, Double> riskData = new LinkedHashMap<String, Double>();
		riskData.put("FamilyHistory", familyHistoryRisk);
		riskData.put("InflammatoryBowelDisease", inflammatoryBowelDiseaseRisk);
		riskData.put("Diabetes", diabetesRisk);
		riskData.put("AlcoholConsumption", alcoholConsumptionRisk);
		riskData.put("Obesity", obesityRisk);
		riskData.put("RedMeatConsumption", redMeatConsumptionRisk);
		riskData.put("ProcessedMeatConsumption", processedMeatConsumptionRisk);
		riskData.put("Smoking", smokingRisk);
		riskData.put("PhysicalActivity", physicalActivityRisk);
		riskData.put("DairyConsumption", dairyConsumptionRisk);
		riskData.put("MilkConsumption", milkConsumptionRisk);

		DecimalFormat df = new DecimalFormat("#.00");
		for (Entry<String, Double> risk : riskData.entrySet()) {
			riskData.put(risk.getKey(), Double.valueOf(df.format(Math.log(risk.getValue()))));
		}
		return riskData;
	}
}

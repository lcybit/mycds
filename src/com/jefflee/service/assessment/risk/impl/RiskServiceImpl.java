package com.jefflee.service.assessment.risk.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jefflee.dto.RiskDto;
import com.jefflee.entity.Risk;
import com.jefflee.service.assessment.risk.RiskService;
import com.jefflee.service.base.impl.BaseServiceImpl;
import com.jefflee.util.BeanUtil;
import com.jefflee.util.DatabaseUtil;

@Service("riskService")
public class RiskServiceImpl extends BaseServiceImpl<RiskDto, Risk, String> implements RiskService {

	public RiskServiceImpl() {
		mapperName = "RiskMapper";
	}

	@Override
	public RiskDto create(RiskDto riskDto) throws Exception {
		// Insert risk
		String riskId = DatabaseUtil.gnr32Uuid();
		Risk risk = new Risk();
		BeanUtil.copyProperties(riskDto, risk);
		risk.setRiskId(riskId);
		if (1 == baseDao.insert(mapperName + ".insert", risk)) {
			BeanUtil.copyPropertiesIgnoreNull(risk, riskDto);
			return riskDto;
		}
		return null;
	}

	@Override
	public RiskDto findById(String riskId) throws Exception {
		Risk risk = baseDao.selectOne(mapperName + ".selectOne", riskId);
		RiskDto riskDto = new RiskDto();
		BeanUtil.copyProperties(risk, riskDto);
		return riskDto;
	}

	@Override
	public List<RiskDto> findList() throws Exception {
		List<Risk> riskList = baseDao.selectList(mapperName + ".selectList", null);
		List<RiskDto> riskDtoList = new ArrayList<RiskDto>();
		for (Risk risk : riskList) {
			RiskDto riskDto = new RiskDto();
			BeanUtil.copyProperties(risk, riskDto);
			riskDtoList.add(riskDto);
		}
		return riskDtoList;
	}

	@Override
	public RiskDto modify(RiskDto riskDto) throws Exception {
		Risk risk = new Risk();
		BeanUtil.copyPropertiesIgnoreNull(riskDto, risk);
		if (1 == baseDao.update(mapperName + ".update", risk)) {
			return riskDto;
		}
		return null;
	}

}

package com.jefflee.service.assessment.risk;

import java.util.List;

import com.jefflee.dto.RiskDto;
import com.jefflee.service.base.BaseService;

public interface RiskService extends BaseService<RiskDto, String> {

	RiskDto create(RiskDto riskDto) throws Exception;

	RiskDto findById(String riskId) throws Exception;

	List<RiskDto> findList() throws Exception;

	RiskDto modify(RiskDto riskDto) throws Exception;

}

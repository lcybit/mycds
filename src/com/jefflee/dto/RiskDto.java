package com.jefflee.dto;

public class RiskDto {
	private String riskId;
	private int riskNo;
	private String name;
	private String category;
	private String alterable;
	private String effect;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RiskDto) {
			return riskId.equals(((RiskDto) obj).getRiskId());
		}
		return super.equals(obj);
	}

	public String getAlterable() {
		return alterable;
	}

	public String getCategory() {
		return category;
	}

	public String getEffect() {
		return effect;
	}

	public String getName() {
		return name;
	}

	public String getRiskId() {
		return riskId;
	}

	public int getRiskNo() {
		return riskNo;
	}

	@Override
	public int hashCode() {
		return this.riskNo;
	}

	public void setAlterable(String alterable) {
		this.alterable = alterable;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRiskId(String riskId) {
		this.riskId = riskId;
	}

	public void setRiskNo(int riskNo) {
		this.riskNo = riskNo;
	}
}

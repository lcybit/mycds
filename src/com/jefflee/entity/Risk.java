package com.jefflee.entity;

public class Risk {
	private String riskId;
	private int riskNo;
	private String name;
	private String category;
	private String alterable;
	private String effect;

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

package com.jefflee.dto;

public class TestDto {
	private String testId;
	private String name;
	private String category;
	private String timeInterval;
	private String performance;
	private String complexity;
	private String benefits;
	private String limitations;

	public String getBenefits() {
		return benefits;
	}

	public String getCategory() {
		return category;
	}

	public String getComplexity() {
		return complexity;
	}

	public String getLimitations() {
		return limitations;
	}

	public String getName() {
		return name;
	}

	public String getPerformance() {
		return performance;
	}

	public String getTestId() {
		return testId;
	}

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	public void setLimitations(String limitations) {
		this.limitations = limitations;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

}

package com.jefflee.dto;

public class OptionDto {

	// database
	private String optionId;
	private String type;
	private String title;
	private String value;
	private String status;

	// others
	private String questionId;

	public String getOptionId() {
		return optionId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public String getStatus() {
		return status;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

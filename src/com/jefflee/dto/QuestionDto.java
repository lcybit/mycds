package com.jefflee.dto;

import java.util.List;

public class QuestionDto {

	// database
	private String questionId;
	private String title;
	private String status;

	// others
	private String questionnaireId;
	private List<OptionDto> optionList;

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(String questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public List<OptionDto> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<OptionDto> optionList) {
		this.optionList = optionList;
	}

}

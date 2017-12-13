package com.jefflee.dto;

import java.util.List;

public class QuestionnaireDto {

	// database
	private String questionnaireId;
	private String theme;
	private String title;
	private String style;
	private String status;

	// others
	private List<QuestionDto> questionList;

	public List<QuestionDto> getQuestionList() {
		return questionList;
	}

	public String getQuestionnaireId() {
		return questionnaireId;
	}

	public String getStatus() {
		return status;
	}

	public String getStyle() {
		return style;
	}

	public String getTheme() {
		return theme;
	}

	public String getTitle() {
		return title;
	}

	public void setQuestionList(List<QuestionDto> questionList) {
		this.questionList = questionList;
	}

	public void setQuestionnaireId(String questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

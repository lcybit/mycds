package com.jefflee.entity;

public class Questionnaire {

	private String questionnaireId;
	private String theme;
	private String title;
	private String style;
	private String status;

	public String getQuestionnaireId() {
		return questionnaireId;
	}

	public String getTheme() {
		return theme;
	}

	public String getTitle() {
		return title;
	}

	public String getStyle() {
		return style;
	}

	public String getStatus() {
		return status;
	}

	public void setQuestionnaireId(String questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

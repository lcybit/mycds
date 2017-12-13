package com.jefflee.entity;

public class Assessment {

	private String assessmentId;
	private String theme;
	private String title;
	private String style;
	private String status;

	public String getAssessmentId() {
		return assessmentId;
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

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
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

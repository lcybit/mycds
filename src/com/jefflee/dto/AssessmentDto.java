package com.jefflee.dto;

public class AssessmentDto extends ComponentDto {

	private String assessmentId;
	private String theme;
	private String title;
	private String style;
	private String status;

	public String getAssessmentId() {
		return assessmentId;
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

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
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

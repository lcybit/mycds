package com.jefflee.entity;

public class Question {

	private String questionId;
	private String title;
	private String status;

	public String getQuestionId() {
		return questionId;
	}

	public String getStatus() {
		return status;
	}

	public String getTitle() {
		return title;
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

}

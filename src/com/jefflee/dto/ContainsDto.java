package com.jefflee.dto;

public class ContainsDto {

	private String containsId;
	private String parentId;
	private String childId;
	private Integer childNo;

	public String getChildId() {
		return childId;
	}

	public Integer getChildNo() {
		return childNo;
	}

	public String getContainsId() {
		return containsId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setChildId(String childId) {
		this.childId = childId;
	}

	public void setChildNo(Integer childNo) {
		this.childNo = childNo;
	}

	public void setContainsId(String containsId) {
		this.containsId = containsId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}

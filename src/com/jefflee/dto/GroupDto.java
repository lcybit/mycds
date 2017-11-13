package com.jefflee.dto;

import java.util.List;

public class GroupDto {

	private String groupId;
	private String title;
	private String status;
	private ComponentDto parentComponent;
	private List<ComponentDto> childComponentList;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
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

	public ComponentDto getParentComponent() {
		return parentComponent;
	}

	public void setParentComponent(ComponentDto parentComponent) {
		this.parentComponent = parentComponent;
	}

	public List<ComponentDto> getChildComponentList() {
		return childComponentList;
	}

	public void setChildComponentList(List<ComponentDto> childComponentList) {
		this.childComponentList = childComponentList;
	}

}

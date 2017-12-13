package com.jefflee.dto;

import java.util.List;

public class ComponentDto {

	private String componentId;
	private ComponentDto parent;
	private List<ComponentDto> childList;

	public List<ComponentDto> getChildList() {
		return childList;
	}

	public String getComponentId() {
		return componentId;
	}

	public ComponentDto getParent() {
		return parent;
	}

	public void setChildList(List<ComponentDto> childList) {
		this.childList = childList;
	}

	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	public void setParent(ComponentDto parent) {
		this.parent = parent;
	}

}

package com.jefflee.controller.base;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseController {

	public Map<String, String[]> getParameterMap() {
		return getRequest().getParameterMap();
	}

	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	public HttpSession getSession() {
		return getRequest().getSession();
	}
}

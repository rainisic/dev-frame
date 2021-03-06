/* @(#) ParameterLoadingInterceptor.java
 * Project:	dev-frame
 * Package:	com.frame.interceptor
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.interceptor;

import static com.frame.util.ApplicationConfiguration.getProperty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.frame.vo.Project;
import com.frame.vo.SEO;

/**
 * Load common parameters.
 * 
 * @author Rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public class ParameterLoadingInterceptor extends HandlerInterceptorAdapter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		// Set project name and project title.
		request.setAttribute("project", new Project(
				getProperty("project.name"), getProperty("project.title"),
				getProperty("project.static_domain")));

		// Set SEO parameters.
		request.setAttribute("seo", new SEO(getProperty("seo.keywords"),
				getProperty("seo.description")));

		return true;
	}
}

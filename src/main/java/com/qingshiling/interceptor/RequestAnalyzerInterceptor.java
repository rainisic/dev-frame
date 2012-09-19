/* @(#) RequestAnalyzerInterceptor.java
 * Project:	dev-frame
 * Package:	com.qingshiling.interceptor
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Rainisic
 * 
 */
public class RequestAnalyzerInterceptor extends HandlerInterceptorAdapter {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		// Set the page forum according the request URI.
		if (request.getRequestURI().startsWith("/index")) {
			request.setAttribute("forum", "index");
		} else if (request.getRequestURI().startsWith("/introduction/")) {
			request.setAttribute("forum", "introduction");
		} else if (request.getRequestURI().startsWith("/activity/")) {
			request.setAttribute("forum", "activity");
		} else if (request.getRequestURI().startsWith("/ticket/")) {
			request.setAttribute("forum", "ticket");
		} else if (request.getRequestURI().startsWith("/direction/")) {
			request.setAttribute("forum", "direction");
		} else if (request.getRequestURI().startsWith("/about/")) {
			request.setAttribute("forum", "about");
		}
		
		return true;
	}
}

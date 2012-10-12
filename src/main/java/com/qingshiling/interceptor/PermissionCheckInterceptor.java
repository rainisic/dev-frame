/* @(#) PermissionCheckInterceptor.java
 * Project:	dev-frame
 * Package: com.qingshiling.interceptor
 * Author:	rainisic
 * Date:	Oct 10, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.frame.util.ApplicationConfiguration;

/**
 * @author rainisic
 * 
 */
public class PermissionCheckInterceptor extends HandlerInterceptorAdapter {

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
		
		// Load server mode.
		String serverMode = ApplicationConfiguration.getProperty("server.mode");
		if (serverMode != null && serverMode.equalsIgnoreCase("RELEASE")) {
			
			// Check session info.
			HttpSession session = request.getSession();

			if (session.getAttribute("system_admin") == null) {
				response.sendRedirect("/login.html");
				return false;
			}
		}
		return true;
	}
}

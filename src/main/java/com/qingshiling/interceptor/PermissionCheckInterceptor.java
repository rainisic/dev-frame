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

		String[] uri = request.getRequestURI().split("/");

		if (uri != null
				&& ((uri.length > 1 && uri[1].equals("admin")) || uri.length > 2
						&& uri[2].equals("admin"))) {

			// Check session info.
			HttpSession session = request.getSession();

			if (session.getAttribute("system_admin") == null) {
				response.sendRedirect("/login.html");
			}
		}

		return true;
	}
}

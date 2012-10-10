/* @(#) IndexController.java
 * Project:	dev-frame
 * Package: com.qingshiling.web
 * Author:	rainisic
 * Date:	Sep 19, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frame.util.ApplicationConfiguration;
import com.qingshiling.constant.ActivityStatus;
import com.qingshiling.entity.Activity;
import com.qingshiling.service.ActivityService;

/**
 * Index controller. Process index request.<br>
 * If a request mapped to "/" and no any controller processed it, the method
 * html will process it in the final. It usually to be used in static page
 * display.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
public class IndexController {

	/** Define activity business processor. */
	@Resource
	private ActivityService activityServiceImpl;

	/**
	 * Process index request.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("index")
	public String index(Model model) {

		// Load activities.
		List<Activity> activities = activityServiceImpl.list(
				ActivityStatus.PUBLISHED, activityServiceImpl.paging(1));

		// Put values to request.
		model.addAttribute("activities", activities);
		model.addAttribute("pageTitle", "首页");
		return "site.index.index";
	}

	/**
	 * Go to the back-system.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("admin/index")
	public String admin(Model model) {
		model.addAttribute("pageTitle", "内部系统首页");
		return "admin.admin.index";
	}

	/**
	 * Go to the login page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("login")
	public String login(Model model) {
		model.addAttribute("pageTitle", "管理员登录");
		return "ajax.html.login";
	}

	/**
	 * Validate user information.
	 * 
	 * @param model
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("validate")
	public String validate(Model model, String username, String password,
			HttpSession session) {
		if (username != null
				&& password != null
				&& username.equals(ApplicationConfiguration
						.getProperty("admin.username"))
				&& password.equals(ApplicationConfiguration
						.getProperty("admin.password"))) {

			// Add session.
			session.setAttribute("system_admin", true);
			return "redirect:/admin/index.html";
		} else {
			model.addAttribute("result", "failure");
			return "forward:/login.html";
		}
	}

	/**
	 * Process static html request.
	 * 
	 * @param model
	 * @param html
	 * @return
	 */
	@RequestMapping("{html}")
	public String html(Model model, @PathVariable String html) {
		if (html.equals("introduction")) {
			model.addAttribute("pageTitle", "白河漂流");
		} else if (html.equals("direction")) {
			model.addAttribute("pageTitle", "如何前往");
		} else if (html.equals("about")) {
			model.addAttribute("pageTitle", "关于我们");
		}
		return "site.html." + html;
	}
}

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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	 * Process static html request.
	 * 
	 * @param model
	 * @param html
	 * @return
	 */
	@RequestMapping("{html}")
	public String html(Model model, @PathVariable String html) {
		if (html.equals("introduction")) {
			model.addAttribute("pageTitle", "漂流简介");
		} else if (html.equals("direction")) {
			model.addAttribute("pageTitle", "如何前往");
		} else if (html.equals("about")) {
			model.addAttribute("pageTitle", "关于我们");
		}
		return "site.html." + html;
	}
}

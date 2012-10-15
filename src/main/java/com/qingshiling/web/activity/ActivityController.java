/* @(#) ActivityController.java
 * Project:	dev-frame
 * Package: com.qingshiling.web.activity
 * Author:	lihonghe
 * Date:	2012-9-19
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.web.activity;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.vo.Page;
import com.qingshiling.constant.ActivityStatus;
import com.qingshiling.entity.Activity;
import com.qingshiling.service.ActivityService;

/**
 * Activity controller.
 * 
 * @author lge
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping("activity")
public class ActivityController {

	/** Define the activity service instance. */
	@Resource
	private ActivityService activityServiceImpl;

	/**
	 * List published activities by page.
	 * 
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping("page/{index}")
	public String list(Model model, Page page, HttpServletRequest request) {

		// Paging activities.
		page = activityServiceImpl.paging(ActivityStatus.PUBLISHED,
				page.getIndex());

		// Get the activities.
		List<Activity> activities = activityServiceImpl.list(
				ActivityStatus.PUBLISHED, page);

		// Put values to request.
		model.addAttribute("activities", activities);
		model.addAttribute("page", page);
		model.addAttribute("pageTitle", "活动列表");

		return "site.activity.list";
	}

	/**
	 * Display an activity.
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("display/{id}")
	public String display(Model model, Activity activity) {

		// Get the activity.
		activity = activityServiceImpl.display(activity.getId());

		// Put values to request.
		model.addAttribute("activity", activity);
		model.addAttribute("pageTitle", activity.getTitle());

		return "site.activity.display";
	}

	/**
	 * List activities for administrator.
	 * 
	 * @param model
	 * @param status
	 * @return
	 */
	@RequestMapping("admin/list")
	public String list(Model model, Integer status) {

		// Define activities list.
		List<Activity> activities;

		// Check query status and query activities.
		if (status == null) {
			activities = activityServiceImpl.list();
		} else {
			activities = activityServiceImpl
					.list(ActivityStatus.values()[status]);
		}

		// Put values to request.
		model.addAttribute("activities", activities);
		model.addAttribute("status", status);
		model.addAttribute("pageTitle", "活动列表");

		return "admin.admin.activity";
	}

	/**
	 * Load activity.
	 * @param id
	 * @return
	 */
	@RequestMapping("admin/load")
	@ResponseBody
	public Object load(Integer id) {
		return activityServiceImpl.display(id);
	}

	/**
	 * 新增活动
	 * 
	 * @param model
	 * @param activity
	 * @return
	 */
	@RequestMapping("admin/publish")
	public String publish(Model model, Activity activity) {
		activityServiceImpl.save(activity);
		return "redirect:/activity/admin/list.html";
	}

	/**
	 * 更新活动
	 * 
	 * @param model
	 * @param activity
	 * @return
	 */
	@RequestMapping("admin/update")
	public String update(Model model, Activity activity) {
		Activity result = activityServiceImpl.update(activity);
		model.addAttribute("activity", result);
		return "redirect:/activity/admin/list.html";
	}

	/**
	 * 删除活动
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("admin/delete")
	public String delete(Model model, Integer id) {
		activityServiceImpl.delete(id);
		return "redirect:/activity/admin/list.html";
	}
}

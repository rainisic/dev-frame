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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String list(Model model, Page page) {

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

	@RequestMapping("admin/list")
	public String list(Model model, Integer status) {
		
		// Check query status.
		if (status == null) {
		} else if (status == 0) {
			model.addAttribute("activities",
					activityServiceImpl.list(ActivityStatus.UNPUBLISHED));
		} else if (status == 1) {
			model.addAttribute("activities",
					activityServiceImpl.list(ActivityStatus.PUBLISHED));
		} else if (status == 2) {
			model.addAttribute("activities",
					activityServiceImpl.list(ActivityStatus.DELETED));
		}
		model.addAttribute("status", status);
		model.addAttribute("pageTitle", "活动列表");
		return "admin.admin.activity";
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
		return "site.activity.display";
	}

	/**
	 * 新增活动
	 * 
	 * @param model
	 * @param activity
	 * @return
	 */
	@RequestMapping("admin/create")
	public String create(Model model, Activity activity) {
		activityServiceImpl.save(activity);
		return "site.activity.list";
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
		return "site.activity.list";
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
		return "site.activity.list";
	}

	/**
	 * Get ActivityList by ActivityStatus;
	 * 
	 * @param model
	 * @param status
	 * @return
	 */
	@RequestMapping("admin/list")
	public String list(Model model, ActivityStatus status) {
		// get unpublished activityList
		if (status == ActivityStatus.UNPUBLISHED) {
			List<Activity> result = activityServiceImpl.list(status, null);
			model.addAttribute("unpublished", result);
			return "site.activity.list";

			// get publish activityList
		} else if (status == ActivityStatus.PUBLISHED) {
			List<Activity> result = activityServiceImpl.list(status, null);
			model.addAttribute("published", result);
			return "site.activity.list";

			// get deleted activityList
		} else {
			List<Activity> result = activityServiceImpl.list(status, null);
			model.addAttribute("deleted", result);
			return "site.activity.list";
		}
	}
}

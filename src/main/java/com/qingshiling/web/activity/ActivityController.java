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
 * @author lge
 * 
 */
@Controller
@RequestMapping("activity")
public class ActivityController {

	@Resource
	private ActivityService activityServiceImpl;

	@RequestMapping("page/{index}")
	public String list(Model model, Page page) {
		
		// Get the activities.
		List<Activity> activities = activityServiceImpl.list(
				ActivityStatus.PUBLISHED, page);
		
		// Put values to request.
		model.addAttribute("activities", activities);
		return "site.activity.list";
	}

	@RequestMapping("display/{id}")
	public String display(Model model, Integer id) {
		return "site.activity.display";
	}

	@RequestMapping
	public String getPablishActivityList(Model model, Page page) {
		if (page == null) {
			throw new RuntimeException("无效参数");
		}
		if (page.getIndex() < 1 || page.getIndex() > 5000) {
			throw new RuntimeException("无效参数");
		}
		if (page.getSize() < 1 || page.getSize() > 500) {
			throw new RuntimeException("无效参数");
		}
		return null;
	}

}

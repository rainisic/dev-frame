/* @(#) ActivityServiceImpl.java
 * Project:	dev-frame
 * Package: com.frame.status.service.impl
 * Author:	lihonghe
 * Date:	2012-9-18
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frame.vo.Page;
import com.qingshiling.dao.ActivityDao;
import com.qingshiling.entity.Activity;
import com.qingshiling.service.ActivityService;

/**
 * 处理优惠活动的业务类
 * 
 * @author lge
 * 
 */
@Service
public class ActivityServiceImpl implements ActivityService {

	@Resource
	private ActivityDao activityDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.frame.status.service.ActivityService#getActivityListToPage(java.lang
	 * .Integer, java.lang.Integer)
	 */
	@Override
	public List<Activity> getActivityListToPage(Page page) {
		List<Activity> result = activityDao.list(
				(page.getIndex() - 1) * page.getSize(), page.getSize());
		if (result != null && result.size() > 0) {
			return result;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.frame.status.service.ActivityService#saveNewActivity(com.frame.status
	 * .entity.Activity)
	 */
	@Override
	@Transactional
	public boolean saveNewActivity(Activity activity) {
		try {
			activity.setStatus(Activity.PUBLISH);
			activityDao.save(activity);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.frame.status.service.ActivityService#updateActivity(com.frame.status
	 * .entity.Activity)
	 */
	@Override
	@Transactional
	public Activity updateActivity(Activity activity) {
		Activity result = activityDao.get(activity.getId());
		if (result != null) {
			result.setTitle(activity.getTitle());
			result.setContent(activity.getContent());
			result.setPriority(activity.getPriority());
			result.setPublishTime(activity.getPublishTime());
			result.setStatus(Activity.PUBLISH);
			activityDao.update(result);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.frame.status.service.ActivityService#deleteActivity(java.lang.Integer
	 * )
	 */
	@Override
	public boolean deleteActivity(Integer id) {
		Activity result = activityDao.get(id);
		if (result != null) {
			result.setStatus(Activity.DELETE);
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qingshiling.service.ActivityService#getPublishActivityList(com.frame
	 * .vo.Page)
	 */
	@Override
	public List<Activity> getPublishActivityList(Page page) {
		return activityDao.findPublishActivityList(page);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qingshiling.service.ActivityService#getDeletedActivityList(com.frame
	 * .vo.Page)
	 */
	@Override
	public List<Activity> getDeletedActivityList(Page page) {
		return activityDao.findDeletedActivityList(page);
	}

	/* (non-Javadoc)
	 * @see com.qingshiling.service.ActivityService#getActivity(java.lang.Integer)
	 */
	@Override
	public Activity getActivity(Integer id) {
		Activity activity = activityDao.get(id);
		if(activity != null){
			return activity;
		}
		return null;
	}

}

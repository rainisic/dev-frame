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

import com.frame.util.ApplicationConfiguration;
import com.frame.vo.Page;
import com.qingshiling.constant.ActivityStatus;
import com.qingshiling.dao.ActivityDao;
import com.qingshiling.entity.Activity;
import com.qingshiling.service.ActivityService;

/**
 * 处理优惠活动的业务类
 * 
 * @author lge (Review and modified by rainisic in Sep 26 2012)
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class ActivityServiceImpl implements ActivityService {

	/**
	 * 将activityDao注入到service层
	 */
	@Resource
	private ActivityDao activityDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qingshiling.service.ActivityService#display(int)
	 */
	@Override
	public Activity display(int id) {
		return activityDao.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qingshiling.service.ActivityService#list(com.frame.vo.Page)
	 */
	@Override
	public List<Activity> list(Page page) {
		return activityDao.list((page.getIndex() - 1) * page.getSize(),
				page.getSize());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qingshiling.service.ActivityService#list(com.qingshiling.constant
	 * .ActivityStatus, com.frame.vo.Page)
	 */
	@Override
	public List<Activity> list(ActivityStatus status, Page page) {
		return activityDao.listActivity(status, page);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qingshiling.service.ActivityService#save(com.qingshiling.entity.Activity
	 * )
	 */
	@Override
	public void save(Activity activity) {
		activityDao.save(activity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qingshiling.service.ActivityService#update(com.qingshiling.entity
	 * .Activity)
	 */
	@Override
	public Activity update(Activity activity) {

		// Load persistent activity by the given activity id.
		Activity persistentActivity = activityDao.get(activity.getId());

		// Update values.
		persistentActivity.setTitle(activity.getTitle());
		persistentActivity.setContent(activity.getContent());
		persistentActivity.setPriority(activity.getPriority());
		persistentActivity.setStatus(activity.getStatus());
		persistentActivity.setPublishTime(activity.getPublishTime());

		return persistentActivity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qingshiling.service.ActivityService#updateStatus(int,
	 * com.qingshiling.constant.ActivityStatus)
	 */
	@Override
	public boolean updateStatus(int id, ActivityStatus status) {

		// Load persistent activity by the given activity id.
		Activity persistentActivity = activityDao.get(id);

		if (persistentActivity != null) {

			// Update status..
			persistentActivity.setStatus(status);
			return true;
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qingshiling.service.ActivityService#delete(int)
	 */
	@Override
	public boolean delete(int id) {

		// Load persistent activity by the given activity id.
		Activity persistentActivity = activityDao.get(id);

		if (persistentActivity != null) {

			// Delete current activity.
			activityDao.delete(persistentActivity);
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see com.qingshiling.service.ActivityService#paging(int)
	 */
	@Override
	public Page paging(int index) {
		
		// Count page.
		Page page = new Page(activityDao.count(),
				Integer.parseInt(ApplicationConfiguration
						.getProperty("page.size")));
		
		// Set index.
		if (index == 0) {
			page.setIndex(1);
		} else {
			page.setIndex(index);
		}
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qingshiling.service.ActivityService#paging(int)
	 */
	@Override
	public Page paging(ActivityStatus status, int index) {
		
		// Count page.
		Page page = new Page(activityDao.count(status),
				Integer.parseInt(ApplicationConfiguration
						.getProperty("page.size")));
		
		// Set index.
		if (index == 0) {
			page.setIndex(1);
		} else {
			page.setIndex(index);
		}
		return page;
	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// *
	// com.frame.status.service.ActivityService#getActivityListToPage(java.lang
	// * .Integer, java.lang.Integer)
	// */
	// @Override
	// public List<Activity> getActivityListToPage(Page page) {
	// List<Activity> result = activityDao.list(
	// (page.getIndex() - 1) * page.getSize(), page.getSize());
	// if (result != null && result.size() > 0) {
	// return result;
	// }
	// return null;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// *
	// com.frame.status.service.ActivityService#saveNewActivity(com.frame.status
	// * .entity.Activity)
	// */
	// @Override
	// @Transactional
	// public boolean saveNewActivity(Activity activity) {
	// try {
	// activity.setStatus(ActivityStatus.PUBLISHED);
	// activityDao.save(activity);
	// } catch (Exception e) {
	// e.printStackTrace();
	// return false;
	// }
	// return true;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// *
	// com.frame.status.service.ActivityService#updateActivity(com.frame.status
	// * .entity.Activity)
	// */
	// @Override
	// @Transactional
	// public Activity updateActivity(Activity activity) {
	// Activity result = activityDao.get(activity.getId());
	// if (result != null) {
	// result.setTitle(activity.getTitle());
	// result.setContent(activity.getContent());
	// result.setPriority(activity.getPriority());
	// result.setPublishTime(activity.getPublishTime());
	// result.setStatus(ActivityStatus.PUBLISHED);
	// activityDao.update(result);
	// }
	// return result;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// *
	// com.frame.status.service.ActivityService#deleteActivity(java.lang.Integer
	// * )
	// */
	// @Override
	// public boolean deleteActivity(Integer id) {
	// Activity result = activityDao.get(id);
	// if (result != null) {
	// result.setStatus(ActivityStatus.DELETED);
	// return true;
	// }
	// return false;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// *
	// com.qingshiling.service.ActivityService#getPublishActivityList(com.frame
	// * .vo.Page)
	// */
	// @Override
	// public List<Activity> getPublishActivityList(Page page) {
	// return activityDao.findPublishActivityList(page);
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// *
	// com.qingshiling.service.ActivityService#getDeletedActivityList(com.frame
	// * .vo.Page)
	// */
	// @Override
	// public List<Activity> getDeletedActivityList(Page page) {
	// return activityDao.findDeletedActivityList(page);
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see
	// * com.qingshiling.service.ActivityService#getActivity(java.lang.Integer)
	// */
	// @Override
	// public Activity getActivity(Integer id) {
	// Activity activity = activityDao.get(id);
	// if (activity != null) {
	// return activity;
	// }
	// return null;
	// }
	//
	// /* (non-Javadoc)
	// * @see com.qingshiling.service.ActivityService#removeActivity(int)
	// */
	// @Override
	// public boolean removeActivity(int id) {
	// Activity activity = activityDao.get(id);
	// if(activity != null){
	// activityDao.delete(activity);
	// return true;
	// }
	// return false;
	// }

}

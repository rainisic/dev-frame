/* @(#) ActivityService.java
 * Project:	dev-frame
 * Package: com.frame.status.service
 * Author:	lihonghe
 * Date:	2012-9-18
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.service;

import java.util.List;

import com.frame.vo.Page;
import com.qingshiling.constant.ActivityStatus;
import com.qingshiling.entity.Activity;

/**
 * Activity service interface. Define the business processor of activity.
 * 
 * @author lge (Review and modified by rainisic in Sep 26 2012)
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ActivityService {

	/**
	 * Get the activity by the given id.
	 * 
	 * @param id
	 *            the activity id.
	 * @return expected activity.
	 */
	public Activity display(int id);

	/**
	 * Get the activities and paging by the page.
	 * 
	 * @param page
	 *            pager.
	 * @return expected activity list.
	 */
	public List<Activity> list(Page page);

	/**
	 * Get the activities in the given status and paging by the page.
	 * 
	 * @param status
	 *            activities status.
	 * @param page
	 *            pager
	 * @return expected activity list.
	 */
	public List<Activity> list(ActivityStatus status, Page page);

	/**
	 * Save an activity.
	 * 
	 * @param activity
	 *            activity to save.
	 */
	public void save(Activity activity);

	/**
	 * Load activity by id and update it.
	 * 
	 * @param activity
	 *            activity contains new content.
	 * @return persistent activity.
	 */
	public Activity update(Activity activity);

	/**
	 * Load the activity by id and set status to the given status.
	 * 
	 * @param status
	 *            activity status.
	 * @return update status success or not.
	 */
	public boolean updateStatus(int id, ActivityStatus status);

	/**
	 * Delete activity by given id.
	 * 
	 * @param id
	 *            activity id to delete.
	 * @return delete success or not.
	 */
	public boolean delete(int id);

	/**
	 * Load page information.
	 * 
	 * @return page.
	 */
	public Page paging(int index);
	
	/**
	 * Load paging information of activities in given status.
	 * @param status
	 * @param index
	 * @return
	 */
	public Page paging(ActivityStatus status, int index);

	//
	// /**
	// * 根据id查询单个活动
	// *
	// * @param id
	// * @author lge
	// * @return Activity
	// */
	// public Activity getActivity(Integer id);
	//
	// /**
	// * 得到优惠活动列表，通过分页
	// *
	// * @param page
	// * @author lge
	// * @return List<Activity>
	// */
	// public List<Activity> getActivityListToPage(Page page);
	//
	// /**
	// * 得到发布的优惠活动列表
	// *
	// * @param page
	// * @author lge
	// * @return List<Activity>
	// */
	// public List<Activity> getPublishActivityList(Page page);
	//
	// /**
	// * 得到删除的优惠活动列表
	// *
	// * @param page
	// * @author lge
	// * @return List<Activity>
	// */
	// public List<Activity> getDeletedActivityList(Page page);
	//
	// /**
	// * 保存新活动
	// *
	// * @param activity
	// * @author lge
	// * @return true or false
	// */
	// public boolean saveNewActivity(Activity activity);
	//
	// /**
	// * 修改活动
	// *
	// * @param activity
	// * @author lge
	// * @return Activity
	// */
	// public Activity updateActivity(Activity activity);
	//
	// /**
	// * 删除活动（假删）
	// *
	// * @param id
	// * @author lge
	// * @return true or false
	// */
	// public boolean deleteActivity(Integer id);
	//
	// /**
	// * 删除垃圾站里的活动（真删）
	// *
	// * @param id
	// * @author lge
	// * @return true or false
	// */
	// public boolean removeActivity(int id);

}

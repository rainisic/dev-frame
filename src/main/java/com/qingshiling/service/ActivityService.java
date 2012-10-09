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
	 * List all activities.
	 * 
	 * @return all activities.
	 */
	public List<Activity> list();

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
	 * Get the activities in given status.
	 * 
	 * @param status
	 *            activities status.
	 * @return expected activity list.
	 */
	public List<Activity> list(ActivityStatus status);

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
	 * 
	 * @param status
	 * @param index
	 * @return
	 */
	public Page paging(ActivityStatus status, int index);
}

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
import com.qingshiling.entity.Activity;

/**
 * 处理优惠活动的接口
 * @author lge
 *
 */
public interface ActivityService {
	/**
	 * 根据id查询单个活动
	 * @param id
	 * @author lge
	 * @return Activity
	 */
	public Activity getActivity(Integer id);
	/**
	 * 得到优惠活动列表，通过分页
	 * @param page
	 * @author lge
	 * @return List<Activity>
	 */
	public List<Activity> getActivityListToPage(Page page);
	/**
	 * 得到发布的优惠活动列表
	 * @param page
	 * @author lge
	 * @return List<Activity>
	 */
	public List<Activity> getPublishActivityList(Page page);
	/**
	 * 得到删除的优惠活动列表
	 * @param page
	 * @author lge
	 * @return List<Activity>
	 */
	public List<Activity> getDeletedActivityList(Page page);
	/**
	 * 保存新活动
	 * @param activity
	 * @author lge
	 * @return true or false
	 */
	public boolean saveNewActivity(Activity activity);
	
	/**
	 * 修改活动
	 * @param activity
	 * @author lge
	 * @return Activity
	 */
	public Activity updateActivity(Activity activity);
	/**
	 * 删除活动（假删）
	 * @param id
	 * @author lge
	 * @return true or false
	 */
	public boolean deleteActivity(Integer id);
	/**
	 * 删除垃圾站里的活动（真删）
	 * @param id
	 * @author lge
	 * @return true or false
	 */
	public boolean removeActivity(int id);

}

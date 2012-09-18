/* @(#) ActivityService.java
 * Project:	dev-frame
 * Package: com.frame.status.service
 * Author:	lihonghe
 * Date:	2012-9-18
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.status.service;

import java.util.List;

import com.frame.status.entity.Activity;
import com.frame.vo.Page;

/**
 * 处理优惠活动的接口
 * @author lge
 *
 */
public interface ActivityService {
	/**
	 * 得到优惠活动列表，通过分页
	 * @param pageNum
	 * @param pageSize
	 * @author lge
	 * @return List<Activity>
	 */
	public List<Activity> getActivityListToPage(Page page);
	
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
	
	public boolean deleteActivity(Integer id);

}

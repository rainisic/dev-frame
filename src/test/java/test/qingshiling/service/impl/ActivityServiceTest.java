/* @(#) ActivityServiceTest.java
 * Project:	dev-frame
 * Package: test.qingshiling.service.impl
 * Author:	lihonghe
 * Date:	2012-9-19
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package test.qingshiling.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.frame.vo.Page;
import com.qingshiling.entity.Activity;
import com.qingshiling.service.ActivityService;

/**
 * @author lge
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-common.xml",
		"classpath:applicationContext-db.xml" })
public class ActivityServiceTest extends AbstractJUnit4SpringContextTests {
	/**
	 * 注入活动对象
	 */
	@Resource
	private ActivityService activityService;
//
//	/**
//	 * 测试查询全部活动列表
//	 */
//	@Test
//	public void getActivityListToPage() {
//		List<Activity> activities = activityService
//				.getActivityListToPage(new Page(0, 1, 10));
//		Assert.assertNull(activities);
//	}
//
//	/**
//	 * 测试查询发布活动列表
//	 */
//	@Test
//	public void getPublishActivityList() {
//		List<Activity> activities = activityService
//				.getPublishActivityList(new Page(0, 1, 10));
//		Assert.assertNotNull(activities);
//		Assert.assertEquals(0, activities.size());
//	}
//
//	/**
//	 * 测试查询被删除的活动列表
//	 */
//	@Test
//	public void getDeletedActivityList() {
//		List<Activity> activities = activityService
//				.getDeletedActivityList(new Page(0, 1, 10));
//		Assert.assertNotNull(activities);
//		Assert.assertEquals(0, activities.size());
//	}
//
//	/**
//	 * 行增优惠活动
//	 */
//	@Test
//	@Rollback
//	public void saveNewActivity() {
//		Activity activity = new Activity();
//		activity.setTitle("十一最新优惠");
//		activity.setContent("敬请期待");
//		activity.setPublishTime(new Date());
////		activity.setPriority(1);
////		activity.setStatus(Activity.PUBLISH);
//		Assert.assertTrue(activityService.saveNewActivity(activity));
//	}
//	/**
//	 * 测试根据id查询activity
//	 * 测试更新活动
//	 */
//	@Test
//	public void updateActivity() {
//		Activity activity = activityService.getActivity(1);
//		if (activity != null) {
//			activity.setTitle("十二最新优惠");
//			activity.setContent("不期待了");
////			activity.setPriority(1);
////			activity.setStatus(Activity.PUBLISH);
//			Assert.assertNotNull(activityService.updateActivity(activity));
//		}
//	}
//	/**
//	 * 测试删除活动功能
//	 */
//	@Test
//	public void deleteActivity(){
//		Assert.assertTrue(activityService.deleteActivity(1));
//	}

}

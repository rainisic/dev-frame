/* @(#) ActivityServiceTest.java
 * Project:	dev-frame
 * Package: test.qingshiling.service.impl
 * Author:	lihonghe
 * Date:	2012-9-19
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package test.qingshiling.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

	/**
	 * 测试查询全部活动列表
	 */
	@Test
	public void getActivityListToPage() {
	}

	/**
	 * 测试查询发布活动列表
	 */
	@Test
	public void getPublishActivityList() {
	}

	/**
	 * 测试查询被删除的活动列表
	 */
	@Test
	public void getDeletedActivityList() {
	}

	/**
	 * 行增优惠活动
	 */
	@Test
	@Rollback
	public void saveNewActivity() {
	}
	/**
	 * 测试根据id查询activity
	 * 测试更新活动
	 */
	@Test
	public void updateActivity() {
	}
	/**
	 * 测试删除活动功能
	 */
	@Test
	public void deleteActivity(){
	}

}

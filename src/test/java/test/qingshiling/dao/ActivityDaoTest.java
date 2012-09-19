/* @(#) ActivityDaoTest.java
 * Project:	dev-frame
 * Package: test.qingshiling.dao
 * Author:	lihonghe
 * Date:	2012-9-19
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package test.qingshiling.dao;

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
import com.qingshiling.dao.ActivityDao;
import com.qingshiling.entity.Activity;

/**
 * @author lge
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-common.xml",
		"classpath:applicationContext-db.xml" })
public class ActivityDaoTest extends AbstractJUnit4SpringContextTests {

	@Resource
	private ActivityDao activityDao;

	@Test
	public void findPublishActivityList() {
		List<Activity> activities = activityDao
				.findPublishActivityList(new Page(0, 1, 10));
		Assert.assertNotNull(activities);
		Assert.assertEquals(1, activities.size());
	}
	@Test
	public void findDeletedActivityList() {
		List<Activity> activities = activityDao
				.findDeletedActivityList(new Page(0, 1, 10));
		Assert.assertNotNull(activities);
		Assert.assertEquals(0, activities.size());
	}

}

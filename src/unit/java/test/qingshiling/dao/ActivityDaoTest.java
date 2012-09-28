/* @(#) ActivityDaoTest.java
 * Project:	dev-frame
 * Package: test.qingshiling.dao
 * Author:	lihonghe
 * Date:	2012-9-19
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package test.qingshiling.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qingshiling.dao.ActivityDao;

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
	}
	@Test
	public void findDeletedActivityList() {
	}

}

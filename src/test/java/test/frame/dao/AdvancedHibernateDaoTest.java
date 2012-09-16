/* @(#) AdvancedHibernateDaoTest.java
 * Project:	dev-frame
 * Package:	test.frame.dao
 * Author:	Rainisic
 * Copyright © 2012 by RainRhyme Internet Studio. All rights reserved.
 */
package test.frame.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.frame.dao.AdvancedHibernateDao;
import com.frame.status.entity.Status;

/**
 * @author Rainisic
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-common.xml",
		"classpath:applicationContext-db.xml" })
public class AdvancedHibernateDaoTest {
	
	@Resource
	private AdvancedHibernateDao<Status> dao;

	@Test
	public void test() {
		System.out.println(dao.count(Status.class));
	}

}

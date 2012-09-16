/* @(#) StatusServiceTest.java
 * Project:	dev-frame
 * Package:	test.frame.status.service
 * Author:	Rainisic
 * Copyright © 2012 by RainRhyme Internet Studio. All rights reserved.
 */
package test.frame.status.service;

import javax.annotation.Resource;

import static junit.framework.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.frame.status.entity.Status;
import com.frame.status.service.StatusService;

/**
 * @author Rainisic
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-common.xml",
		"classpath:applicationContext-db.xml" })
public class StatusServiceTest extends AbstractJUnit4SpringContextTests {

	@Resource
	private StatusService statusServiceImpl;

	@Test
	public void addStatus() {
		Status st = statusServiceImpl.saveStatus();
		assertEquals(st.getId(), 1);
		assertEquals(st.getSystem(), System.getProperty("os.name"));
		assertEquals(st.getJdk(), System.getProperty("java.version"));
	}

}

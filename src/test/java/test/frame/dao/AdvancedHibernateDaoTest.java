/* @(#) AdvancedHibernateDaoTest.java
 * Project:	dev-frame
 * Package:	test.frame.dao
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package test.frame.dao;

import java.lang.reflect.Field;

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
	public AdvancedHibernateDao<Status> dao;
	
	@Resource
	public AdvancedHibernateDao<com.frame.status.entity.Test> dao2;

	@Test
	public void test() {
		try {
			Field c = AdvancedHibernateDaoTest.class.getField("dao");  
			Field c2 = AdvancedHibernateDaoTest.class.getField("dao2");
			
			Field f = Field.class.getDeclaredField("signature");  
			f.setAccessible(true);  
			System.out.println(((String) f.get(c)));
			System.out.println(((String) f.get(c2)));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
        
	}

}

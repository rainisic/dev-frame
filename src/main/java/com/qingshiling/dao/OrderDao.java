/* @(#) OrderDao.java
 * Project:	dev-frame
 * Package: com.qingshiling.dao
 * Author:	lihonghe
 * Date:	2012-9-21
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.dao;

import org.springframework.stereotype.Repository;
import com.frame.dao.AdvancedHibernateDao;
import com.qingshiling.entity.Order;

/**
 * @author lge
 * 
 */
@Repository
public class OrderDao extends AdvancedHibernateDao<Order> {
	
	/* (non-Javadoc)
	 * @see com.frame.dao.AdvancedHibernateDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Order entity) {
	}
}

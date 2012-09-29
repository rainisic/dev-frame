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
 * Data access class for the table "ticket_order".
 * 
 * @author lge
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class OrderDao extends AdvancedHibernateDao<Order> {
}

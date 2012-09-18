/* @(#) StatusDao.java
 * Project:	dev-frame
 * Package: com.frame.status.dao.impl
 * Author:	rainisic
 * Date:	Sep 18, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.status.dao.impl;

import org.springframework.stereotype.Repository;

import com.frame.dao.AdvancedHibernateDao;
import com.frame.status.entity.Status;

/**
 * 
 * Status DAO class.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class StatusDao extends AdvancedHibernateDao<Status> {
}

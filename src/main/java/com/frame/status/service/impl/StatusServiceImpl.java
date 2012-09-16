/* @(#) StatusServiceImpl.java
 * Project:	dev-frame
 * Package:	com.frame.status.service.impl
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.status.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.dao.AdvancedHibernateDao;
import com.frame.status.entity.Status;
import com.frame.status.service.StatusService;

/**
 * Frame status service implementation.
 * 
 * @author Rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class StatusServiceImpl implements StatusService {

	/** Define the advanced hibernate data access class. */
	@Resource
	private AdvancedHibernateDao<Status> dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.status.service.StatusService#saveStatus()
	 */
	@Override
	public Status saveStatus() {

		// Check database connection status.
		Status st = dao.findById(Status.class, 1);
		if (st != null) {
			dao.delete(st);
		}
		dao.save(new Status());
		return dao.findById(Status.class, 1);
	}
}

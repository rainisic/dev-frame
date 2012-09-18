/* @(#) StatusServiceImpl.java
 * Project:	dev-frame
 * Package:	com.frame.status.service.impl
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.status.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.status.dao.impl.StatusDao;
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
	private StatusDao statusDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.status.service.StatusService#saveStatus()
	 */
	@Override
	public Status saveStatus() {

		// Check database connection status.
		Status st = statusDao.get(1);
		if (st != null) {
			statusDao.delete(st);
		}
		statusDao.save(new Status());
		return statusDao.get(1);
	}
}

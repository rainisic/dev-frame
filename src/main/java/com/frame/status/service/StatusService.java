/* @(#) StatusService.java
 * Project:	dev-frame
 * Package:	com.frame.status.service
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.status.service;

import com.frame.status.entity.Status;

/**
 * Frame status service interface.
 * 
 * @author Rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public interface StatusService {

	/**
	 * Get the frame status, save and return it.
	 * 
	 * @return Frame status.
	 */
	public Status saveStatus();
}

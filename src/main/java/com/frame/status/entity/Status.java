/* @(#) Status.java
 * Project:	dev-frame
 * Package:	com.frame.status.entity
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.status.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * System status entity. This class contains the system info and JDK info. The
 * purpose is to check the framework status.
 * 
 * @author Rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
@Table(name = "frame_status")
public class Status {

	/** Status ID. Must be 1. */
	@Id
	private int id;

	/** System info. */
	@Column(nullable = false)
	private String system;

	/** JDK version. */
	@Column(nullable = false)
	private String jdk;

	/**
	 * Default constructor. In this constructor, it will collection all required
	 * information and store it.
	 */
	public Status() {

		// Load the system information.
		id = 1;
		system = System.getProperty("os.name");
		jdk = System.getProperty("java.version");
	}

	/**
	 * @return the id(Will be 1).
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the system information.
	 */
	public String getSystem() {
		return system;
	}

	/**
	 * @return the JDK version.
	 */
	public String getJdk() {
		return jdk;
	}
}

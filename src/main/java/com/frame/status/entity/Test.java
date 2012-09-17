/* @(#) Test.java
 * Project:	dev-frame
 * Package: com.frame.status.entity
 * Author:	rainisic
 * Date:	Sep 17, 2012
 * Copyright © 2012 by RainRhyme Internet Studio. All rights reserved.
 */
package com.frame.status.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.stereotype.Repository;

/**
 * @author rainisic
 * 
 */
@Entity
public class Test {

	@Id
	@GeneratedValue
	private int id;

	private int value;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
}

/* @(#) TestEntity.java
 * Project:	dev-frame
 * Package: com.frame.entity
 * Author:	rainisic
 * Date:	Sep 14, 2012
 * Copyright © 2012 by RainRhyme Internet Studio. All rights reserved.
 */
package com.frame.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test entity class.
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
public class TestEntity {
	
	/** Test entity primary key. Auto increment. */
	@Id
	@GeneratedValue
	@Autowired
	private int id;
	
	/** Test entity value field. Not null and default 0. */
	@Column(nullable = false, columnDefinition = "int default 0")
	@Autowired
	private int value;
	
}

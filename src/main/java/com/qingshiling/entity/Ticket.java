/* @(#) Ticket.java
 * Project:	dev-frame
 * Package: com.qingshiling.entity
 * Author:	rainisic
 * Date:	Sep 27, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public class Ticket {

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String type;

	@Column
	private int price;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
}

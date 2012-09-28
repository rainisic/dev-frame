/* @(#) Ticket.java
 * Project:	dev-frame
 * Package: com.qingshiling.entity
 * Author:	rainisic
 * Date:	Sep 27, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Ticket entity class.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
public class Ticket {

	/** Identifier. */
	@Id
	@GeneratedValue
	private int id;

	/** Ticket type. */
	@Column(nullable = false)
	private String name;

	/** Price. */
	@Column(nullable = false)
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

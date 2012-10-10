/* @(#) Album.java
 * Project:	dev-frame
 * Package: com.qingshiling.entity
 * Author:	rainisic
 * Date:	Sep 28, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Album entity class.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
public class Album {

	/** Identifier. */
	@Id
	@GeneratedValue
	private int id;

	/** Album name. */
	@Column(nullable = false, length = 10)
	private String name;

	/** Descriptions. */
	@Column(nullable = false)
	private String description;

	/** Cover image. */
	@JoinColumn
	@ManyToOne
	private Picture cover;

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the cover
	 */
	public Picture getCover() {
		return cover;
	}

	/**
	 * @param cover
	 *            the cover to set
	 */
	public void setCover(Picture cover) {
		this.cover = cover;
	}
}
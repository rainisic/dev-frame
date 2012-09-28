/* @(#) Picture.java
 * Project:	dev-frame
 * Package: com.qingshiling.entity
 * Author:	rainisic
 * Date:	Sep 28, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 * Picture entity class. Store the picture information. The real image is stored
 * in the folder which configured in the config.properties.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public class Picture {

	/** Identifier. */
	@Id
	@GeneratedValue
	private int id;

	/** Picture display name. */
	@Column(nullable = false, length = 100)
	private String name;

	/** Descriptions. */
	@Column(nullable = false)
	private String description;

	/** File relative path. */
	@Column(nullable = false)
	private String path;

	/** In which album. */
	@JoinColumn
	private Album album;

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
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the album
	 */
	public Album getAlbum() {
		return album;
	}

	/**
	 * @param album
	 *            the album to set
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}
}

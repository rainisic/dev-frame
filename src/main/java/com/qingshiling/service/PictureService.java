/* @(#) PictureService.java
 * Project:	dev-frame
 * Package: com.qingshiling.service
 * Author:	rainisic
 * Date:	Sep 29, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.service;

import java.util.List;

import com.qingshiling.entity.Picture;

/**
 * @author rainisic
 * 
 */
public interface PictureService {

	/**
	 * List all picture in given album.
	 * 
	 * @param albumId
	 *            album id.
	 * @return picture list.
	 */
	public List<Picture> list(int albumId);

	/**
	 * Save a new picture.
	 * 
	 * @param picture
	 *            picture to save.
	 */
	public void save(Picture picture);

	/**
	 * Update an exists picture.
	 * 
	 * @param picture
	 *            picture to update.
	 * @return success or not.s
	 */
	public boolean update(Picture picture);

	/**
	 * Delete a picture.
	 * 
	 * @param id
	 *            picture to delete.
	 * @return success or not.
	 */
	public boolean delete(int id);
}

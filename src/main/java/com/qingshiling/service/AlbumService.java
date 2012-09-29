/* @(#) AlbumService.java
 * Project:	dev-frame
 * Package: com.qingshiling.service
 * Author:	rainisic
 * Date:	Sep 29, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.service;

import java.util.List;

import com.qingshiling.entity.Album;

/**
 * Album service interface. Define the business processor of album.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AlbumService {

	/**
	 * Get the album by the given album id.
	 * 
	 * @param id
	 *            album id.
	 * @return album or null(if not exist).
	 */
	public Album get(int id);

	/**
	 * List all albums.
	 * 
	 * @return album list.
	 */
	public List<Album> list();

	/**
	 * Save a new album.
	 * 
	 * @param album
	 *            album to save.
	 */
	public void save(Album album);

	/**
	 * Update an exists album.
	 * 
	 * @param album
	 *            album to update.
	 * @return success or not.
	 */
	public boolean update(Album album);

	/**
	 * Delete an album.
	 * 
	 * @param id
	 *            id of album to delete.
	 * @return success or not.
	 */
	public boolean delete(int id);
}

/* @(#) AlbumServiceImpl.java
 * Project:	dev-frame
 * Package: com.qingshiling.service.impl
 * Author:	rainisic
 * Date:	Sep 29, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingshiling.dao.AlbumDao;
import com.qingshiling.entity.Album;
import com.qingshiling.service.AlbumService;

/**
 * Process business of album.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class AlbumServiceImpl implements AlbumService {

	/** Album data access object. */
	@Resource
	private AlbumDao albumDao;

	/* (non-Javadoc)
	 * @see com.qingshiling.service.AlbumService#get(int)
	 */
	@Override
	public Album get(int id) {
		return albumDao.get(id);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qingshiling.service.AlbumService#list()
	 */
	@Override
	public List<Album> list() {
		return albumDao.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qingshiling.service.AlbumService#save(com.qingshiling.entity.Album)
	 */
	@Override
	public void save(Album album) {
		albumDao.save(album);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qingshiling.service.AlbumService#update(com.qingshiling.entity.Album)
	 */
	@Override
	public boolean update(Album album) {

		// Load the album.
		Album persistentAlbum = albumDao.get(album.getId());

		if (persistentAlbum != null) {

			// Update the album.
			persistentAlbum.setName(album.getName());
			persistentAlbum.setDescription(album.getDescription());

			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qingshiling.service.AlbumService#delete(int)
	 */
	@Override
	public boolean delete(int id) {

		// Load the album.
		Album album = albumDao.get(id);

		if (album != null) {

			// Delete the album.
			albumDao.delete(album);
			return true;
		}
		return false;
	}
}

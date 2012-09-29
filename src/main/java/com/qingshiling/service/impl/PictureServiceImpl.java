/* @(#) PictureServiceImpl.java
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

import com.qingshiling.dao.PictureDao;
import com.qingshiling.entity.Album;
import com.qingshiling.entity.Picture;
import com.qingshiling.service.AlbumService;
import com.qingshiling.service.PictureService;

/**
 * Process picture business
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class PictureServiceImpl implements PictureService {

	/** Picture data access object. */
	@Resource
	private PictureDao pictureDao;

	/** Album service object. */
	@Resource
	private AlbumService albumServiceImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qingshiling.service.PictureService#list(int)
	 */
	@Override
	public List<Picture> list(int albumId) {

		// Find the album.
		Album album = albumServiceImpl.get(albumId);

		if (album != null) {
			return pictureDao.list(album);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qingshiling.service.PictureService#save(com.qingshiling.entity.Picture
	 * )
	 */
	@Override
	public void save(Picture picture) {
		pictureDao.save(picture);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qingshiling.service.PictureService#update(com.qingshiling.entity.
	 * Picture)
	 */
	@Override
	public boolean update(Picture picture) {

		// Get the picture.
		Picture persistentPicture = pictureDao.get(picture.getId());

		if (persistentPicture != null) {

			// Update picture data.
			persistentPicture.setName(picture.getName());
			persistentPicture.setDescription(picture.getDescription());

			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qingshiling.service.PictureService#delete(int)
	 */
	@Override
	public boolean delete(int id) {

		// Get the picture.
		Picture picture = pictureDao.get(id);

		if (picture != null) {

			// Delete picture.
			pictureDao.delete(picture);

			return true;
		}
		return false;
	}
}

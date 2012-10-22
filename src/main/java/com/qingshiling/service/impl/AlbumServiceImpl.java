/* @(#) AlbumServiceImpl.java
 * Project:	dev-frame
 * Package: com.qingshiling.service.impl
 * Author:	rainisic
 * Date:	Sep 29, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qingshiling.dao.AlbumDao;
import com.qingshiling.dao.PictureDao;
import com.qingshiling.entity.Album;
import com.qingshiling.entity.Picture;
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

	/** picture date access pbject */
	@Resource
	private PictureDao pictureDao;

	/*
	 * (non-Javadoc)
	 * 
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
	public boolean delete(int id, String realPath) {

		// Load the album.
//		Album album = albumDao.get(id);
//		if (album != null) {
//			List<Picture> pictures = pictureDao.list(album);
//			if (pictures != null && pictures.size() > 0) {
//				for (int i = 0; i < pictures.size(); i++) {
//					//传入图片所在位置
//					File file = new File(realPath + pictures.get(i).getPath());
//					//判断图片是否存在
//					if (file.exists()) {
//						file.delete();
//					}
//				}
//			}
//			// Delete the album.
//			albumDao.delete(album);
//			return true;
//		}
		
		albumDao.delete(albumDao.get(id));
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qingshiling.service.AlbumService#setCover(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	@Transactional
	public boolean setCover(Integer albumId, Integer pictureId) {
		Picture pickture = pictureDao.get(pictureId);
		Album album = albumDao.get(albumId);
		if (pickture != null && album != null) {
			album.setCover(pickture);
			albumDao.update(album);
			return true;
		}
		return false;
	}

}

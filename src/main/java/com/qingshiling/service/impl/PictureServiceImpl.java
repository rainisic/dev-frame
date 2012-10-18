/* @(#) PictureServiceImpl.java
 * Project:	dev-frame
 * Package: com.qingshiling.service.impl
 * Author:	rainisic
 * Date:	Sep 29, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.service.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frame.util.ApplicationConfiguration;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qingshiling.service.PictureService#publish(org.springframework.web
	 * .multipart.MultipartFile, com.qingshiling.entity.Picture)
	 */
	@Override
	@Transactional
	public void publish(InputStream fileStream, Picture picture,String realPath, String fileName) {
		// 生成uuid
		String uuid = UUID.randomUUID().toString();
		String path = uuid + fileName.substring(fileName.indexOf("."));
		picture.setPath(path);
		pictureDao.save(picture);
		uploadImgMethod(fileStream,uuid,realPath,fileName);
	}
	
	/**
	 * 上传文件方法
	 * 
	 * @param pictureFile
	 * @param uuid
	 */
	private void uploadImgMethod(InputStream fileStream, String uuid, String realPath, String fileName) {
		// 查找存放文件目录,判断此目录是否存在，不存在创建
		String saveDirectory = getSaveDirectory(realPath);
		BufferedInputStream bis = null;
		InputStream in = fileStream;
		FileOutputStream fos = null;
		try {
			// 上传图片
			bis = new BufferedInputStream(in);
			//输出路径（路径+(/OR\)+名字+后缀）
			fos = new FileOutputStream(saveDirectory + File.separator + uuid
					+ fileName.substring(fileName.indexOf(".")));
			int BUFFER_SIZE = 1024 * 10;
			byte[] buf = new byte[BUFFER_SIZE];
			int size = 0;
			while ((size = bis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				if (in != null) {
					in.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 查找存放文件目录,判断此目录是否存在，不存在创建
	 * 
	 * @return
	 */
	private String getSaveDirectory(String realPath) {
		String saveDirectory = realPath + ApplicationConfiguration.getProperty("upload.location") + File.separator;
		// 判断此目录是否存在，不存在创建
		File file = new File(saveDirectory);
		if (!file.exists()) {
			file.mkdirs();
		}
		return saveDirectory;
	}
}

/* @(#) PicktureController.java
 * Project:	dev-frame
 * Package: com.qingshiling.web.picture
 * Author:	lihonghe
 * Date:	2012-10-12
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.web.album;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.qingshiling.entity.Picture;
import com.qingshiling.service.PictureService;

/**
 * @author lge
 * 
 */
@Controller
@RequestMapping("album/picture")
public class PictureController {

	@Resource
	private PictureService pictureServiceImpl;

	@RequestMapping("admin/list")
	public String list(Model model, Integer id) {
		model.addAttribute("pictures", pictureServiceImpl.list(id));
		model.addAttribute("album", id);
		return "admin.admin.picture";
	}

	/**
	 * upload a picture.
	 * 
	 * @param model
	 * @param pictureFile
	 * @param picture
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("admin/publish")
	public String publish(Model model, MultipartFile pictureFile,
			Picture picture, HttpServletRequest request) throws IOException {
		if (pictureFile != null && picture != null) {
			String realPath = request.getSession().getServletContext()
					.getRealPath("/");
			InputStream fileStream = pictureFile.getInputStream();
			String fileName = pictureFile.getOriginalFilename();
			pictureServiceImpl.publish(fileStream, picture, realPath, fileName);
			if (fileStream != null) {
				fileStream.close();
			}
			model.addAttribute("id", picture.getAlbum().getId());
			return "redirect:/album/picture/admin/list.html";
		}
		return "redirect:/album/admin/list.html";
	}

	/**
	 * update a picture message
	 * 
	 * @param model
	 * @param picture
	 * @return
	 */
	@RequestMapping("admin/update")
	public String update(Model model, Picture picture) {
		pictureServiceImpl.update(picture);
		model.addAttribute("id", picture.getAlbum().getId());
		return "redirect:/album/picture/admin/list.html";
	}
	
	/**
	 * delete a picture from an album.
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("admin/delete")
	public String delete(Model model, Integer pictureId, Integer albumId){
		pictureServiceImpl.delete(pictureId);
		model.addAttribute("id", albumId);
		return "redirect:/album/picture/admin/list.html";
	}

}
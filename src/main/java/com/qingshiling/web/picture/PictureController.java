/* @(#) PicktureController.java
 * Project:	dev-frame
 * Package: com.qingshiling.web.picture
 * Author:	lihonghe
 * Date:	2012-10-12
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.web.picture;

import javax.annotation.Resource;

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
		return "admin.admin.picture";
	}
	
	/**
	 * upload a picture.
	 * 
	 * @param model
	 * @param pictureFile
	 * @param picture
	 * @return
	 */
	@RequestMapping("admin/publish")
	public String publish(Model model, MultipartFile pictureFile,Picture picture){
		
		if(pictureFile != null && picture !=null){
			pictureServiceImpl.publish(pictureFile, picture);
			return "";
		}
		return "";
	}

	@RequestMapping("admin/test")
	public String publish(Model model){
		return "site.activity.test";
	}

}

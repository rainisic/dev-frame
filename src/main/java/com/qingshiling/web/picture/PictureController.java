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
@RequestMapping("picture")
public class PictureController {
	
	@Resource
	private PictureService pictureServiceImpl;
	
	/**
	 * upload a picture.
	 * 
	 * @param model
	 * @param pictureFile
	 * @param picture
	 * @return
	 */
	@RequestMapping("publish")
	public String publish(Model model, MultipartFile pictureFile,Picture picture){
		if(pictureFile != null && picture !=null){
			pictureServiceImpl.publish(pictureFile, picture);
			return "";
		}
		return "";
	}


}

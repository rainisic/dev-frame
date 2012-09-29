/* @(#) AlbumController.java
 * Project:	dev-frame
 * Package:	com.qingshiling.web.album
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.web.album;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qingshiling.service.AlbumService;
import com.qingshiling.service.PictureService;

/**
 * Album controller.
 * 
 * @author Rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping("album")
public class AlbumController {

	/** Define album service. */
	@Resource
	private AlbumService albumServiceImpl;
	
	/** Define picture service. */
	@Resource
	private PictureService pictureServiceImpl;

	/**
	 * List all albums.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String list(Model model) {

		// Add album list to request.
		model.addAttribute("albums", albumServiceImpl.list());
		return "site.album.list";
	}

	/**
	 * Display the pictures.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("display/{id}")
	public String display(Model model, @PathVariable Integer id) {

		// Add pictures.
		model.addAttribute("pictures", pictureServiceImpl.list(id));
		return "ajax.album.display";
	}
}

/* @(#) AlbumController.java
 * Project:	dev-frame
 * Package:	com.qingshiling.web.album
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.web.album;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qingshiling.entity.Album;
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
		model.addAttribute("pageTitle", "漂流风采");
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

	@RequestMapping("admin/list")
	public String manage(Model model) {

		// Add album list to request.
		model.addAttribute("albums", albumServiceImpl.list());
		model.addAttribute("pageTitle", "漂流风采");
		return "admin.admin.album";
	}
	
	/**
	 * add a album.
	 * 
	 * @param model
	 * @param album
	 * @return
	 */
	@RequestMapping("admin/publish")
	public String publish(Model model, Album album){
		albumServiceImpl.save(album);
		return "redirect:/album/admin/list.html";
	}
	
	/**
	 * update a album.
	 * 
	 * @param model
	 * @param album
	 * @return
	 */
	@RequestMapping("admin/update")
	public String update(Model model, Album album){
		albumServiceImpl.update(album);
		return "redirect:/album/admin/list.html";
	}
	
	/**
	 * delete a album.
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("admin/delete")
	public String delete(Model model, Integer id, HttpServletRequest request){
		String realPath = request.getSession().getServletContext().getRealPath("/");
		if(albumServiceImpl.delete(id,realPath)){
			return "redirect:album/admin/list.html";
		}
		return "redirect:album/admin/list.html";
	}
	
	/**
	 * set cover for an album.
	 * 
	 * @param model
	 * @param albumId
	 * @param pictureId
	 * @return
	 */
	@RequestMapping("admin/setCover")
	public String setCover(Model model, Integer albumId, Integer pictureId){
		if(albumServiceImpl.setCover(albumId, pictureId)){
			return "redirect:/album/admin/list.html";
		}
		return "redirect:/album/admin/list.html";
	}
}

/* @(#) AlbumController.java
 * Project:	dev-frame
 * Package:	com.qingshiling.web.album
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.web.album;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Rainisic
 *
 */
@Controller
@RequestMapping("album")
public class AlbumController {

	@RequestMapping("list")
	public String list() {
		return "site.album.list";
	}
	
	@RequestMapping("display/{id}")
	public String display(Integer id) {
		return "ajax.album.display";
	}
}
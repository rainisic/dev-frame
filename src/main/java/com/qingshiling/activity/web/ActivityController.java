/* @(#) ActivityController.java
 * Project:	dev-frame
 * Package: com.qingshiling.activity.web
 * Author:	lihonghe
 * Date:	2012-9-19
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.activity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frame.vo.Page;

/**
 * @author lge
 * 
 */
@Controller
@RequestMapping("activity")
public class ActivityController {

	@RequestMapping("page/{index}")
	public String list(Model model, Page page) {
		return "site.activity.list";
	}
}

/* @(#) ActivityController.java
 * Project:	dev-frame
 * Package: com.qingshiling.web.activity
 * Author:	lihonghe
 * Date:	2012-9-19
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.web.activity;

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
	
	@RequestMapping("display/{id}")
	public String display(Model model, Integer id) {
		return "site.activity.display";
	}
	
	@RequestMapping
	public String getPablishActivityList(Model model, Page page) {
		if (page == null) {
			throw new RuntimeException("无效参数");
		}
		if(page.getIndex() < 1 || page.getIndex() > 5000){
			throw new RuntimeException("无效参数");
		}
		if(page.getSize() < 1 || page.getSize() > 500){
			throw new RuntimeException("无效参数");
		}
		return null;
	}

}

/* @(#) ActivityController.java
 * Project:	dev-frame
 * Package: com.qingshiling.web
 * Author:	lihonghe
 * Date:	2012-9-19
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frame.vo.Page;

/**
 * @author lge
 * 
 */
@Controller
@RequestMapping(value = "web")
public class ActivityController {

	@RequestMapping()
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

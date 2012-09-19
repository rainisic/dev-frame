/* @(#) IndexController.java
 * Project:	dev-frame
 * Package: com.qingshiling.web
 * Author:	rainisic
 * Date:	Sep 19, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author rainisic
 *
 */
@Controller
public class IndexController {

	@RequestMapping("/index")
	public String index(Model model) {
		return "site.index.index";
	}
}

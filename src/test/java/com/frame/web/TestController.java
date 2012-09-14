/* @(#) TestController.java
 * Project:	dev-frame
 * Package: com.frame.web
 * Author:	rainisic
 * Date:	Sep 14, 2012
 * Copyright © 2012 by RainRhyme Internet Studio. All rights reserved.
 */
package com.frame.web;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Test controller.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping("/test")
public class TestController {

	/**
	 * Test site request.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/site")
	public String site(Model model) {
		return "site.test.index";
	}

	/**
	 * Test ajax request.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/ajax")
	@ResponseBody
	public String ajax(Model model) {
		return "Congratulations! Ajax is ready to use.";
	}
}

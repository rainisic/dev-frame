/* @(#) StatusController.java
 * Project:	dev-frame
 * Package:	com.frame.status.web.status
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.status.web.status;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frame.status.entity.Status;
import com.frame.status.service.StatusService;

/**
 * Frame status check controller.<br>
 * You can visit <address>http://localhost:[port]/status/check-status.html</address>
 * to check the framework status.
 * 
 * @author Rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping("status")
public class StatusController {

	/** Define the frame status service. */
	@Resource
	private StatusService statusService;

	/**
	 * Check the frame status and persist it.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("check-status")
	public String display(Model model) {

		// Load and add frame status.
		Status st = statusService.saveStatus();
		if (st != null) {
			model.addAttribute("status", st);
		}

		// Add page title.
		model.addAttribute("pageTitle", "Frame Status");
		return "site.frame-status.index";
	}
}

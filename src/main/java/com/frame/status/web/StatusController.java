/* @(#) StatusController.java
 * Project:	dev-frame
 * Package:	com.frame.status.web
 * Author:	Rainisic
 * Copyright © 2012 by RainRhyme Internet Studio. All rights reserved.
 */
package com.frame.status.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frame.status.entity.Status;
import com.frame.status.service.StatusService;

/**
 * Frame status check controller.<br>
 * You can visit <address>http://localhost:[port]/frame/check-status</address>
 * to check the framework status.
 * 
 * @author Rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping("frame")
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
		Status st = statusService.saveStatus();
		if (st != null) {
			model.addAttribute("status", st);
		}
		return "ajax.frame-status.index";
	}
}

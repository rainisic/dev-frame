/* @(#) OrderController.java
 * Project:	dev-frame
 * Package:	com.qingshiling.web.order
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.web.order;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingshiling.entity.Order;
import com.qingshiling.service.OrderService;

/**
 * @author Rainisic
 * 
 */
@Controller
@RequestMapping("order")
public class OrderController {

	/** Define the order service instance. */
	@Resource
	private OrderService orderServiceImpl;

	/**
	 * Load ticket information and forward to order page.
	 * 
	 * @return
	 */
	@RequestMapping("create")
	public String create() {
		return "site.order.create";
	}

	/**
	 * Commit the order.
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping("publish")
	@ResponseBody
	public String publish(Order order, HttpServletResponse response) {

		if (order.getContact() != null
				&& order.getContact().trim().length() > 0
				&& order.getPhone() != null
				&& order.getPhone().trim().length() > 0) {

			// Save order.
			orderServiceImpl.save(order);
			return "success";
		}
		
		return "failure";
	}
}

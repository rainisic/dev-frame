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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingshiling.entity.Order;
import com.qingshiling.service.OrderService;
import com.qingshiling.service.TicketService;

/**
 * Ticket order controller.
 * 
 * @author Rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequestMapping("order")
public class OrderController {

	/** Define the order service instance. */
	@Resource
	private OrderService orderServiceImpl;

	/** Define the ticket service instance. */
	@Resource
	private TicketService ticketServiceImpl;

	/**
	 * Load ticket information and forward to order page.
	 * 
	 * @return
	 */
	@RequestMapping("create")
	public String create(Model model) {

		// Load ticket types.
		model.addAttribute("tickets", ticketServiceImpl.list());
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

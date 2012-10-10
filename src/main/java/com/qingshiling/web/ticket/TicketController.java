/* @(#) TicketController.java
 * Project:	dev-frame
 * Package: com.qingshiling.web.ticket
 * Author:	rainisic
 * Date:	Sep 28, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.web.ticket;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qingshiling.entity.Ticket;
import com.qingshiling.service.TicketService;

/**
 * @author rainisic
 *
 */
@Controller
@RequestMapping("ticket")
public class TicketController {
	/** Define the ticket service instance. */
	@Resource
	TicketService ticketServiceImpl;

	/**
	 * Add ticket kinds.
	 * 
	 * @param model
	 * @param ticket
	 * @return
	 */
	@RequestMapping("admin/publish")
	public String publish(Model model, Ticket ticket){
		ticketServiceImpl.save(ticket);
		return "redirect:/ticket/admin/list.html";
	}
	
	/**
	 * Update a ticket message.
	 * 
	 * @param model
	 * @param ticket
	 * @return
	 */
	@RequestMapping("admin/update")
	public String update(Model model, Ticket ticket){
		ticketServiceImpl.update(ticket);
		return "redirect:/ticket/admin/list.html";
	}
	
	/**
	 * Get ticketList.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("admin/list")
	public String list(Model model){
		model.addAttribute("tickets", ticketServiceImpl.list());
		model.addAttribute("pageTitle", "门票管理");
		return "admin.admin.ticket";
	}
	
	/**
	 * Delete a ticket
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("admin/delete")
	public String delete(Model model, Integer id){
		ticketServiceImpl.delete(id);
		return "redirect:/ticket/admin/list.html";
	}
}

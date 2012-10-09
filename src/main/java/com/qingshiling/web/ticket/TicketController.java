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
	TicketService ticketService;

	/**
	 * Add ticket kinds.
	 * 
	 * @param model
	 * @param ticket
	 * @return
	 */
	@RequestMapping("publish")
	public String publish(Model model, Ticket ticket){
		ticketService.save(ticket);
		return "redirect:/ticket/list";
	}
	
	/**
	 * Update a ticket message.
	 * 
	 * @param model
	 * @param ticket
	 * @return
	 */
	@RequestMapping("update")
	public String update(Model model, Ticket ticket){
		ticketService.update(ticket);
		return "redirect:/ticket/list";
	}
	
	/**
	 * Get ticketList.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String list(Model model){
		ticketService.list();
		return "site.ticket.list";
	}
	
	/**
	 * Delete a ticket
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(Model model, Integer id){
		ticketService.delete(id);
		return "redirect:/ticket/list";
	}
}

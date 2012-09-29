/* @(#) TicketService.java
 * Project:	dev-frame
 * Package: com.qingshiling.service
 * Author:	rainisic
 * Date:	Sep 28, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.service;

import java.util.List;

import com.qingshiling.entity.Ticket;

/**
 * Ticket service interface. Define the business processor of ticket.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public interface TicketService {

	/**
	 * Save a new ticket type.
	 * 
	 * @param ticket
	 *            new ticket.
	 */
	public void save(Ticket ticket);

	/**
	 * Delete a ticket type.
	 * 
	 * @param id
	 *            ticket type id.
	 * @return success or not.
	 */
	public boolean delete(int id);

	/**
	 * Get all ticket type.
	 * 
	 * @return ticket type.
	 */
	public List<Ticket> list();
}

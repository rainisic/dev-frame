/* @(#) TicketServiceImpl.java
 * Project:	dev-frame
 * Package: com.qingshiling.service.impl
 * Author:	rainisic
 * Date:	Sep 28, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingshiling.dao.TicketDao;
import com.qingshiling.entity.Ticket;
import com.qingshiling.service.TicketService;

/**
 * Ticket business interface implementation.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class TicketServiceImpl implements TicketService {

	/** Ticket data access object. */
	@Resource
	private TicketDao ticketDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qingshiling.service.TicketService#save(com.qingshiling.entity.Ticket)
	 */
	@Override
	public void save(Ticket ticket) {
		ticketDao.save(ticket);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qingshiling.service.TicketService#delete(int)
	 */
	@Override
	public boolean delete(int id) {
		
		// Get the ticket.
		Ticket ticket = ticketDao.get(id);

		if (ticket != null) {
			ticketDao.delete(ticket);
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qingshiling.service.TicketService#list()
	 */
	@Override
	public List<Ticket> list() {
		return ticketDao.list();
	}

}

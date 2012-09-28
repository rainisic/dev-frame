/* @(#) OrderServiceImpl.java
 * Project:	dev-frame
 * Package: com.qingshiling.service.impl
 * Author:	lihonghe
 * Date:	2012-9-21
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qingshiling.dao.OrderDao;
import com.qingshiling.entity.Order;
import com.qingshiling.service.OrderService;

/**
 * Process order ticket business service.
 * 
 * @author lge
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
public class OrderServiceImpl implements OrderService {

	/** Order data access object. */
	@Resource
	private OrderDao orderDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qingshiling.service.OrderService#save(com.qingshiling.entity.Order)
	 */
	@Override
	public void save(Order order) {
		
		// Get current date and time. 
		order.setCreateTime(Calendar.getInstance().getTime());
		orderDao.save(order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qingshiling.service.OrderService#delete(int)
	 */
	@Override
	public boolean delete(int id) {

		// Get the order.
		Order order = orderDao.get(id);

		if (order != null) {

			// Delete the order. In actually, just change the order status.
			orderDao.delete(order);
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qingshiling.service.OrderService#list()
	 */
	@Override
	public List<Order> list() {
		return orderDao.list();
	}
}

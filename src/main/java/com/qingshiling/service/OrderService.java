/* @(#) OrderService.java
 * Project:	dev-frame
 * Package: com.qingshiling.service
 * Author:	lihonghe
 * Date:	2012-9-21
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.service;

import java.util.List;

import com.qingshiling.entity.Order;

/**
 * @author lge
 * 
 */
public interface OrderService {

	/**
	 * Save a new order.
	 * 
	 * @param order
	 *            order to save.
	 */
	public void save(Order order);

	/**
	 * Delete an order.
	 * 
	 * @param id
	 *            order id.
	 * @return delete success or not.
	 */
	public boolean delete(int id);

	/**
	 * List all order.
	 * 
	 * @return expected order list.
	 */
	public List<Order> list();
}

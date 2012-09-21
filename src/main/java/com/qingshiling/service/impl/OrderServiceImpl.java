/* @(#) OrderServiceImpl.java
 * Project:	dev-frame
 * Package: com.qingshiling.service.impl
 * Author:	lihonghe
 * Date:	2012-9-21
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.frame.vo.Page;
import com.qingshiling.dao.OrderDao;
import com.qingshiling.entity.Order;
import com.qingshiling.service.OrderService;

/**
 * @author lge
 * 
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao orderDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qingshiling.service.OrderService#saveOrder(com.qingshiling.entity
	 * .Order)
	 */
	@Override
	public void saveOrder(Order order) {
		order.setCreateTime(new Date());
		orderDao.save(order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qingshiling.service.OrderService#deleteOrder(int[])
	 */
	@Override
	public boolean deleteOrder(int[] idItem) {
		for (int i = 0; i < idItem.length; i++) {
			Order order = orderDao.get(idItem[i]);
			if (order != null) {
				orderDao.delete(order);
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qingshiling.service.OrderService#findOrderList(com.frame.vo.Page)
	 */
	@Override
	public List<Order> findOrderList(Page page) {
		List<Order> order = orderDao.list(
				(page.getIndex() - 1) * page.getSize(), page.getSize());
		if (order != null) {
			return order;
		}
		return null;
	}

}

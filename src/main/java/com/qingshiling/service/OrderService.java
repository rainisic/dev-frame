/* @(#) OrderService.java
 * Project:	dev-frame
 * Package: com.qingshiling.service
 * Author:	lihonghe
 * Date:	2012-9-21
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.service;

import java.util.List;

import com.frame.vo.Page;
import com.qingshiling.entity.Order;

/**
 * @author lge
 *
 */
public interface OrderService {
	
	/**
	 * 保存订票信息
	 * @param order
	 * @author lge
	 * @return
	 */
	public void saveOrder(Order order);
	/**
	 * 根据订单id数组 删除订单
	 * @param id
	 * @return
	 */
	public boolean deleteOrder(int[] idItem);
	/**
	 * 分页查询订票信息列表
	 * @param page
	 * @return
	 */
	public List<Order> findOrderList(Page page);

}

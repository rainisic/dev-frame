/* @(#) OrderTicket.java
 * Project:	dev-frame
 * Package: com.qingshiling.entity
 * Author:	lihonghe
 * Date:	2012-9-20
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 订票实体类
 * @author lge
 *
 */
@Entity
public class OrderTicket {
	/**
	 * id
	 */
	@Id
	@GeneratedValue
	private int id;
	/**
	 * 订票数量
	 */
	@Column
	private int orderNumber;
	/**
	 * 票的种类
	 */
	@Column
	private int ticketType;
	/**
	 * 手机号码
	 */
	@Column(nullable = false,length = 11)
	private String mobileNum;
	/**
	 * qq号码
	 */
	@Column
	private String qq;
	/**
	 * 留言
	 */
	@Column
	private String message;
	/**
	 * 真实姓名
	 */
	@Column
	private String realName;
	
	

}

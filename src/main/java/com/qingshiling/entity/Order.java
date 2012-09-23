/* @(#) OrderTicket.java
 * Project:	dev-frame
 * Package: com.qingshiling.entity
 * Author:	lihonghe
 * Date:	2012-9-20
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 订票实体类
 * @author lge
 *
 */
@Entity
@Table(name = "ticket_order")
public class Order {
	/**
	 * id
	 */
	@Id
	@GeneratedValue
	private int id;
	/**
	 * 订票数量
	 */
	private int orderNumber;
	/**
	 * 票的种类
	 */
	@Column(nullable = false)
	private int ticketType;
	/**
	 * 手机号码
	 */
	@Column(nullable = false,length = 11)
	private String phone;
	/**
	 * qq号码
	 */
	private String qq;
	/**
	 * 留言
	 */
	private String message;
	/**
	 * 真实姓名
	 */
	@Column(nullable = false)
	private String realName;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 下单日期
	 */
	private Date createTime;
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the orderNumber
	 */
	public int getOrderNumber() {
		return orderNumber;
	}
	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	/**
	 * @return the ticketType
	 */
	public int getTicketType() {
		return ticketType;
	}
	/**
	 * @param ticketType the ticketType to set
	 */
	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the qq
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * @param qq the qq to set
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}

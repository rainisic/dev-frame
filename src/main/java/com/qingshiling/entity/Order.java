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
 * 
 * @author lge (Review and modified by rainisic in Sep 28 2012)
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
@Table(name = "ticket_order")
public class Order {

	/** Order serial number. */
	@Id
	@GeneratedValue
	private int id;

	/** Contact name. */
	@Column(nullable = false, length = 10)
	private String contact;

	/** Contact phone number. */
	@Column(nullable = false, length = 20)
	private String phone;

	/** Contact email. */
	private String email;

	/** Contact QQ. */
	@Column(length = 10)
	private String qq;

	/** Something remark. */
	@Column(columnDefinition = "text")
	private String remark;

	/** Order publish time. */
	@Column(nullable = false)
	private Date createTime;
	
	/** Ticket information. */
	@Column(nullable = false)
	private String ticketInfo;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact
	 *            the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the qq
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * @param qq
	 *            the qq to set
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the ticketInfo
	 */
	public String getTicketInfo() {
		return ticketInfo;
	}

	/**
	 * @param ticketInfo the ticketInfo to set
	 */
	public void setTicketInfo(String ticketInfo) {
		this.ticketInfo = ticketInfo;
	}
}

/* @(#) Activity.java
 * Project:	dev-frame
 * Package:	com.frame.qingshiling.entity
 * Author:	lihonghe
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * TODO
 * 
 * @author lge 2012-9-13
 * 
 */
@Entity
public class Activity {
	
	/**
	 * 活动状态 删除等于2
	 */
	public static final int DELETE = 2;
	/**
	 * 活动状态 发布等于1
	 */
	public static final int PUBLISH = 1;

	/**
	 * Activity id
	 */
	@Id
	@GeneratedValue
	private Integer id;
	/**
	 * Activity title 活动标题
	 */
	@Column(nullable = false)
	private String title;
	/**
	 * Activity content 活动内容
	 */
	@Column(nullable = false, length=5000)
	private String content;
	/**
	 * Activity publishTime 活动发布时间
	 */
	@Column()
	private Date publishTime;
	/**
	 * Activity priority 活动优先级
	 */
	@Column(nullable = false)
	private Integer priority;
	/**
	 * Activity status 活动状态
	 */
	@Column(nullable = false)
	private Integer status;
	
	/**
	 * 空的构造方法
	 */
	public Activity(){
		
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the publishTime
	 */
	public Date getPublishTime() {
		return publishTime;
	}

	/**
	 * @param publishTime
	 *            the publishTime to set
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

}

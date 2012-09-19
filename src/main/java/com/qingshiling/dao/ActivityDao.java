/* @(#) ActivityDao.java
 * Project:	dev-frame
 * Package: com.frame.dao
 * Author:	lihonghe
 * Date:	2012-9-18
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.frame.dao.AdvancedHibernateDao;
import com.frame.vo.Page;
import com.qingshiling.entity.Activity;

/**
 * @author lge
 * 
 */
@Repository
public class ActivityDao extends AdvancedHibernateDao<Activity> {
	
	/**
	 * 将hibernateTemplate注入到DAO层
	 */
	@Resource
	HibernateTemplate hibernateTemplate;

	/**
	 * 查询发布的活动列表
	 * 
	 * @author lge
	 * @return List<Activity>
	 */
	@SuppressWarnings("unchecked")
	public List<Activity> findPublishActivityList(Page page) {
		DetachedCriteria crit = DetachedCriteria.forClass(Activity.class);
		crit.add(Restrictions.eq("status", Activity.PUBLISH));
		return super.getHibernateTemplate().findByCriteria(crit,
				(page.getIndex() - 1) * page.getSize(), page.getSize());
	}

	/**
	 * 查询删除了的活动列表
	 * 
	 * @author lge
	 * @return List<Activity>
	 */
	@SuppressWarnings("unchecked")
	public List<Activity> findDeletedActivityList(Page page) {
		DetachedCriteria crit = DetachedCriteria.forClass(Activity.class);
		crit.add(Restrictions.eq("status", Activity.DELETE));
		return super.getHibernateTemplate().findByCriteria(crit,
				(page.getIndex() - 1) * page.getSize(), page.getSize());
	}

}

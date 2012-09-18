/* @(#) ActivityDao.java
 * Project:	dev-frame
 * Package: com.frame.dao
 * Author:	lihonghe
 * Date:	2012-9-18
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.frame.status.entity.Activity;

/**
 * @author lge
 * 
 */
@Repository
public class ActivityDao extends AdvancedHibernateDao<Activity>{
	@Resource
	HibernateTemplate hibernateTemplate;
	/**
	 * 查询发布的活动列表
	 * @author lge
	 * @return List<Activity>
	 */
//	@SuppressWarnings("unchecked")
//	public List<Activity> findPublishActivityList() {
//		DetachedCriteria crit = DetachedCriteria.forClass(Activity.class);
//		crit.add(Restrictions.eq("status", Activity.PUBLISH));
//		super.getHibernateTemplate()
//		return hibernateTemplate.findByCriteria(crit);
//	}

}

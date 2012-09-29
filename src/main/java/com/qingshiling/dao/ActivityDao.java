/* @(#) ActivityDao.java
 * Project:	dev-frame
 * Package: com.frame.dao
 * Author:	lihonghe
 * Date:	2012-9-18
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.frame.dao.AdvancedHibernateDao;
import com.frame.vo.Page;
import com.qingshiling.constant.ActivityStatus;
import com.qingshiling.entity.Activity;

/**
 * Data access class for the table "Activity".
 * 
 * @author lge (Review and modified by rainisic in Sep 26 2012)
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class ActivityDao extends AdvancedHibernateDao<Activity> {

	/**
	 * List activity by activity status and paging the result.
	 * 
	 * @param status
	 *            activity status.
	 * 
	 * @param page
	 *            page.
	 * @return expected activity list.
	 */
	@SuppressWarnings("unchecked")
	public List<Activity> listActivity(ActivityStatus status, Page page) {

		// Create criteria.
		DetachedCriteria criteria = DetachedCriteria.forClass(Activity.class);

		// Add ActivityStatus restriction.
		if (status != null) {
			criteria.add(Restrictions.eq("status", status));
		}

		criteria.addOrder(Property.forName("priority").desc()).addOrder(
				Property.forName("publishTime").desc());

		// Paging.
		if (page != null) {
			return hibernateTemplate.findByCriteria(criteria,
					(page.getIndex() - 1) * page.getSize(), page.getSize());
		} else {
			return hibernateTemplate.findByCriteria(criteria);
		}
	}

	/**
	 * Get total row count of that activity is in given status.
	 * 
	 * @param status
	 *            activity status.
	 * @return row count.
	 */
	public int count(ActivityStatus status) {

		// Create criteria.
		DetachedCriteria criteria = DetachedCriteria.forClass(Activity.class);

		// Check status.
		if (status != null) {
			criteria.add(Restrictions.eq("status", status));
		}

		return ((Long) hibernateTemplate
				.findByCriteria(criteria.setProjection(Projections.rowCount()))
				.iterator().next()).intValue();
	}
}

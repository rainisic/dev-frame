/* @(#) AdvancedHibernateDao.java
 * Project:	dev-frame
 * Package: com.frame.dao
 * Author:	rainisic
 * Date:	Sep 14, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.frame.vo.Page;

/**
 * Provide advanced hibernate data access functions.<br>
 * All simple data access can use this class instead of define a new one.<br>
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class AdvancedHibernateDao<T> implements AdvancedDao<T> {

	/** Hibernate access object. */
	@Resource
	private HibernateTemplate hibernateTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#save(java.lang.Object)
	 */
	public void save(T entity) {
		hibernateTemplate.save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#save(java.util.Collection)
	 */
	public void save(Collection<T> entities) {
		for (T entity : entities) {
			save(entity);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#save(T[])
	 */
	public void save(T... entities) {
		for (T entity : entities) {
			save(entity);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#update(java.lang.Object)
	 */
	public void update(T entity) {
		hibernateTemplate.save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#update(java.util.Collection)
	 */
	public void update(Collection<T> entities) {
		for (T entity : entities) {
			update(entity);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#update(T[])
	 */
	public void update(T... entities) {
		for (T entity : entities) {
			update(entity);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#saveOrUpdate(java.lang.Object)
	 */
	public void saveOrUpdate(T entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#saveOrUpdate(java.util.Collection)
	 */
	public void saveOrUpdate(Collection<T> entities) {
		for (T entity : entities) {
			saveOrUpdate(entity);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#saveOrUpdate(T[])
	 */
	public void saveOrUpdate(T... entities) {
		for (T entity : entities) {
			saveOrUpdate(entity);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#delete(java.lang.Object)
	 */
	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#delete(java.util.Collection)
	 */
	public void delete(Collection<T> entities) {
		hibernateTemplate.deleteAll(entities);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#delete(T[])
	 */
	public void delete(T... entities) {
		for (T entity : entities) {
			hibernateTemplate.delete(entity);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#findById(java.lang.Class,
	 * java.io.Serializable)
	 */
	public T findById(Class<T> entityClass, Serializable id) {
		return hibernateTemplate.get(entityClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#list(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(Class<T> entityClass) {
		return hibernateTemplate.findByCriteria(DetachedCriteria
				.forClass(entityClass));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#list(java.lang.Class, com.frame.vo.Page)
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(Class<T> entityClass, Page page) {
		return hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(entityClass), (page.getIndex() - 1)
						* page.getSize(), page.getSize());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.frame.dao.AdvancedDao#count(java.lang.Class)
	 */
	public int count(Class<T> entityClass) {
		return ((Long) hibernateTemplate
				.findByCriteria(
						DetachedCriteria.forClass(entityClass).setProjection(
								Projections.rowCount())).iterator().next())
				.intValue();
	}
}

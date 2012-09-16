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
 * If you need more features, you should composite this class into the new
 * class.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class AdvancedHibernateDao<T> {

	/** Hibernate access object. */
	@Resource
	private HibernateTemplate hibernateTemplate;

	/**
	 * Persist the given transient instance.
	 * 
	 * @param entity
	 *            the transient instance to persist.
	 */
	public void save(T entity) {
		hibernateTemplate.save(entity);
	}

	/**
	 * Persist all transient instances in the given collection.
	 * 
	 * @param entities
	 *            the transient instance collection to persist.
	 */
	public void save(Collection<T> entities) {
		for (T entity : entities) {
			save(entity);
		}
	}

	/**
	 * Persist all given transient instances.
	 * 
	 * @param entities
	 *            the transient instance array to persist.
	 */
	public void save(T... entities) {
		for (T entity : entities) {
			save(entity);
		}
	}

	/**
	 * Update the given persistent instance, associating it with the current
	 * Hibernate Session.
	 * 
	 * @param entity
	 *            the persistent instance to update
	 */
	public void update(T entity) {
		hibernateTemplate.save(entity);
	}

	/**
	 * Update all persistent instances in the given collection, associating all
	 * persistent instances with the current Hibernate Session.
	 * 
	 * @param entities
	 *            the persistent instance collection to update
	 */
	public void update(Collection<T> entities) {
		for (T entity : entities) {
			update(entity);
		}
	}

	/**
	 * Update all given persistent instances, associating all persistent
	 * instances with the current Hibernate Session.
	 * 
	 * @param entities
	 *            the persistent instance array to update
	 */
	public void update(T... entities) {
		for (T entity : entities) {
			update(entity);
		}
	}

	/**
	 * Save or update the given persistent instance, according to its id
	 * (matching the configured "unsaved-value"?). Associates the instance with
	 * the current Hibernate Session.
	 * 
	 * @param entity
	 *            the persistent instance to save or update (to be associated
	 *            with the Hibernate Session)
	 */
	public void saveOrUpdate(T entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}

	/**
	 * Save or update all persistent instances in the given collection,
	 * according to its id (matching the configured "unsaved-value"?).
	 * Associates all instances with the current Hibernate Session.
	 * 
	 * @param entities
	 *            the persistent instance collection to save or update (to be
	 *            associated with the Hibernate Session)
	 */
	public void saveOrUpdate(Collection<T> entities) {
		for (T entity : entities) {
			saveOrUpdate(entity);
		}
	}

	/**
	 * Save or update all given persistent instances, according to its id
	 * (matching the configured "unsaved-value"?). Associates all instances with
	 * the current Hibernate Session.
	 * 
	 * @param entities
	 *            the persistent instance collection to save or update (to be
	 *            associated with the Hibernate Session)
	 */
	public void saveOrUpdate(T... entities) {
		for (T entity : entities) {
			saveOrUpdate(entity);
		}
	}

	/**
	 * Delete the given persistent instance.
	 * 
	 * @param entity
	 *            the persistent instance to delete
	 */
	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}

	/**
	 * Delete all persistent instances in the given collection.
	 * 
	 * @param entities
	 *            the persistent instance collection to delete.
	 */
	public void delete(Collection<T> entities) {
		hibernateTemplate.deleteAll(entities);
	}

	/**
	 * Delete all given persistent instances.
	 * 
	 * @param entities
	 *            the persistent instance array to delete.
	 */
	public void delete(T... entities) {
		for (T entity : entities) {
			hibernateTemplate.delete(entity);
		}
	}

	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier, or null if not found.
	 * 
	 * @param entityClass
	 *            the class name of the persistent entity
	 * @param id
	 *            the identifier of the persistent instance
	 * @return the persistent instance, or null if not found
	 */
	public T findById(Class<T> entityClass, Serializable id) {
		return hibernateTemplate.get(entityClass, id);
	}

	/**
	 * Return all persistent instance of the given entity class.
	 * 
	 * @param entityClass
	 *            the class name you want to query.
	 * @return containing 0 or more persistent instances
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(Class<T> entityClass) {
		return hibernateTemplate.findByCriteria(DetachedCriteria
				.forClass(entityClass));
	}

	/**
	 * Return persistent instances of the given entity class. Paging by the
	 * given page.
	 * 
	 * @param entityClass
	 *            the class name you want to query.
	 * @param page
	 *            paging object.
	 * @return containing 0 or more persistent instances
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(Class<T> entityClass, Page page) {
		return hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(entityClass), (page.getIndex() - 1)
						* page.getSize(), page.getSize());
	}

	/**
	 * Return total persistent instances count of the given entity class.
	 * 
	 * @param entityClass
	 *            the class name of the persistent entity
	 * @return persistent instances count.
	 */
	public int count(Class<T> entityClass) {
		return ((Long) hibernateTemplate
				.findByCriteria(
						DetachedCriteria.forClass(entityClass).setProjection(
								Projections.rowCount())).iterator().next())
				.intValue();
	}
}

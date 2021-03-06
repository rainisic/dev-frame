/* @(#) AdvancedHibernateDao.java
 * Project:	dev-frame
 * Package: com.frame.dao
 * Author:	rainisic
 * Date:	Sep 14, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Provide advanced hibernate data access functions.<br>
 * All simple data access can use this class instead of define a new one.<br>
 * 
 * @author rainisicfirstResult
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AdvancedHibernateDao<T> {

	/** Hibernate access object. */
	@Resource
	protected HibernateTemplate hibernateTemplate;

	/** Finalize class type. */
	private final Class<T> clazz;

	/**
	 * Default constructor. Get the finalize class type.
	 */
	public AdvancedHibernateDao() {
		this.clazz = getParameterClass();
	}

	/**
	 * Get the finalize class type.
	 * 
	 * @return raw type class.
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getParameterClass() {
		Class<?> c = getClass();
		while (c != Object.class) {
			Type t = c.getGenericSuperclass();
			if (t instanceof ParameterizedType) {
				Type[] args = ((ParameterizedType) t).getActualTypeArguments();
				if (args[0] instanceof Class) {
					return (Class<T>) args[0];
				}
			}
			c = c.getSuperclass();
		}
		return null;
	}

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
	 * Update the given persistent instance.
	 * 
	 * @param entity
	 *            the persistent instance to update
	 */
	public void update(T entity) {
		hibernateTemplate.save(entity);
	}

	/**
	 * Update all persistent instances in the given collection.
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
	 * Update all given persistent instances.
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
	 * (matching the configured "unsaved-value"?).
	 * 
	 * @param entity
	 *            the persistent instance to save or update.
	 */
	public void saveOrUpdate(T entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}

	/**
	 * Save or update all persistent instances in the given collection,
	 * according to its id (matching the configured "unsaved-value"?).
	 * 
	 * @param entities
	 *            the persistent instance collection to save or update.
	 */
	public void saveOrUpdate(Collection<T> entities) {
		for (T entity : entities) {
			saveOrUpdate(entity);
		}
	}

	/**
	 * Save or update all given persistent instances, according to its id
	 * (matching the configured "unsaved-value"?).
	 * 
	 * @param entities
	 *            the persistent instance collection to save or update.
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
	 * @param id
	 *            the identifier of the persistent instance
	 * @return the persistent instance, or null if not found
	 */
	public T get(Serializable id) {
		return hibernateTemplate.get(clazz, id);
	}

	/**
	 * Return all persistent instance.
	 * 
	 * @return containing 0 or more persistent instances
	 */
	@SuppressWarnings("unchecked")
	public List<T> list() {
		return hibernateTemplate.findByCriteria(DetachedCriteria
				.forClass(clazz));
	}

	/**
	 * Return all persistent instance. Limit by parameters.
	 * 
	 * @param firstResult
	 *            the index of the first result object to be retrieved (numbered
	 *            from 0)
	 * @param maxResults
	 *            the maximum number of result objects to retrieve (or <=0 for
	 *            no limit)
	 * @return containing 0 or more persistent instances
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(int firstResult, int maxResults) {
		return hibernateTemplate.findByCriteria(
				DetachedCriteria.forClass(clazz), firstResult, maxResults);
	}

	/**
	 * Get the hibernate template.
	 * 
	 * @return the hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
}

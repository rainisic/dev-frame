/* @(#) AdvancedDao.java
 * Project:	dev-frame
 * Package: com.frame.dao
 * Author:	rainisic
 * Date:	Sep 17, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import com.frame.vo.Page;

/**
 * Provide advanced data persist functions.<br>
 * All simple data access can use this class instead of define a new one.<br>
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AdvancedDao<T> {

	/**
	 * Persist the given transient instance.
	 * 
	 * @param entity
	 *            the transient instance to persist.
	 */
	public void save(T entity);

	/**
	 * Persist all transient instances in the given collection.
	 * 
	 * @param entities
	 *            the transient instance collection to persist.
	 */
	public void save(Collection<T> entities);

	/**
	 * Persist all given transient instances.
	 * 
	 * @param entities
	 *            the transient instance array to persist.
	 */
	public void save(T... entities);

	/**
	 * Update the given persistent instance.
	 * 
	 * @param entity
	 *            the persistent instance to update
	 */
	public void update(T entity);

	/**
	 * Update all persistent instances in the given collection.
	 * 
	 * @param entities
	 *            the persistent instance collection to update
	 */
	public void update(Collection<T> entities);

	/**
	 * Update all given persistent instances.
	 * 
	 * @param entities
	 *            the persistent instance array to update
	 */
	public void update(T... entities);

	/**
	 * Save or update the given persistent instance, according to its id
	 * (matching the configured "unsaved-value"?).
	 * 
	 * @param entity
	 *            the persistent instance to save or update.
	 */
	public void saveOrUpdate(T entity);

	/**
	 * Save or update all persistent instances in the given collection,
	 * according to its id (matching the configured "unsaved-value"?).
	 * 
	 * @param entities
	 *            the persistent instance collection to save or update.
	 */
	public void saveOrUpdate(Collection<T> entities);

	/**
	 * Save or update all given persistent instances, according to its id
	 * (matching the configured "unsaved-value"?).
	 * 
	 * @param entities
	 *            the persistent instance collection to save or update.
	 */
	public void saveOrUpdate(T... entities);

	/**
	 * Delete the given persistent instance.
	 * 
	 * @param entity
	 *            the persistent instance to delete
	 */
	public void delete(T entity);

	/**
	 * Delete all persistent instances in the given collection.
	 * 
	 * @param entities
	 *            the persistent instance collection to delete.
	 */
	public void delete(Collection<T> entities);

	/**
	 * Delete all given persistent instances.
	 * 
	 * @param entities
	 *            the persistent instance array to delete.
	 */
	public void delete(T... entities);

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
	public T findById(Class<T> entityClass, Serializable id);

	/**
	 * Return all persistent instance of the given entity class.
	 * 
	 * @param entityClass
	 *            the class name you want to query.
	 * @return containing 0 or more persistent instances
	 */
	public List<T> list(Class<T> entityClass);

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
	public List<T> list(Class<T> entityClass, Page page);

	/**
	 * Return total persistent instances count of the given entity class.
	 * 
	 * @param entityClass
	 *            the class name of the persistent entity
	 * @return persistent instances count.
	 */
	public int count(Class<T> entityClass);
}

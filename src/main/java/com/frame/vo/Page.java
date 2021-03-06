/* @(#) Page.java
 * Project:	dev-frame
 * Package:	com.frame.vo
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.vo;

/**
 * Value object for paging. It's contains three fields: page count, current page
 * and page size.
 * 
 * @author Rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public class Page {

	/** Default page size. */
	public static final int DEFAULT_SIZE = 20;

	/** Total page count. */
	private int count;

	/** Current page. */
	private int index;

	/** Page size. */
	private int size;

	/**
	 * Default constructor.
	 */
	public Page() {
	}

	/**
	 * Calculate page by record count and page size.
	 * 
	 * @param recordCount
	 *            record count.
	 * @param size
	 *            page size.
	 */
	public Page(int recordCount, int size) {
		this.index = 0;
		this.size = size;
		this.count = recordCount == 0 ? 1 : (recordCount + (size - 1)) / size;
	}

	/**
	 * Constructor with page count, page size and current page.
	 * 
	 * @param count
	 *            page count.
	 * @param index
	 *            current page.
	 * @param size
	 *            page size.
	 */
	public Page(int count, int index, int size) {
		this.count = count;
		this.index = index;
		this.size = size;
	}

	/**
	 * @return total page count.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            total page count to set.
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return current page.
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            current page to set.
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the page size.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the page size to set.
	 */
	public void setSize(int size) {
		this.size = size;
	}
}

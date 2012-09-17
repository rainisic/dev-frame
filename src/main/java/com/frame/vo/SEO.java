/* @(#) SEO.java
 * Project:	dev-frame
 * Package: com.frame.vo
 * Author:	rainisic
 * Date:	Sep 17, 2012
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.vo;

/**
 * SEO value object.
 * 
 * @author rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public class SEO {

	/** SEO keywords. */
	private String keywords;

	/** SEO description. */
	private String description;

	/**
	 * Default constructor.
	 */
	public SEO() {
	}

	/**
	 * Full parameter constructor.
	 * 
	 * @param keywords
	 *            SEO keywords.
	 * @param description
	 *            SEO description.
	 */
	public SEO(String keywords, String description) {
		this.keywords = keywords;
		this.description = description;
	}

	/**
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords
	 *            the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}

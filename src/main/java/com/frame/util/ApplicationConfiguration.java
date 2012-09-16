/* @(#) ApplicationConfiguration.java
 * Project:	dev-frame
 * Package:	com.frame.util
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Application configuration store.
 * 
 * @author Rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public class ApplicationConfiguration {

	/** Properties. */
	private static Properties properties = new Properties();

	/**
	 * Load application configuration.
	 * 
	 * @param stream
	 */
	public static void load(InputStream inStream) {

		try {
			properties.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get property value by given key.
	 * 
	 * @param key
	 *            property key.
	 * @return property value.
	 */
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	/**
	 * Get all properties.
	 * 
	 * @return all properties.
	 */
	public static Properties getProperties() {
		return properties;
	}
}

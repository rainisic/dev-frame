/* @(#) ConfigureLoaderListener.java
 * Project:	dev-frame
 * Package:	com.frame.listener
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.frame.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.frame.util.ApplicationConfiguration;

/**
 * Load application configuration from the configure file.
 * 
 * @author Rainisic
 * @version 1.0.0
 * @since 1.0.0
 */
public class ConfigureLoaderListener implements ServletContextListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 * .ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {

		// Get application configuration location.
		String appConfigLocation = event.getServletContext().getInitParameter(
				"appConfigLocation");

		// Check application configuration file.
		if (appConfigLocation == null) {
			appConfigLocation = "classpath:config.properties";
		}

		// Load configuration file.
		if (appConfigLocation.startsWith("classpath:")) {

			// Load from classpath.
			ApplicationConfiguration.load(this.getClass().getResourceAsStream(
					"/" + appConfigLocation.substring(10).trim()));
		} else {

			// Load from Web root.
			ApplicationConfiguration.load(event.getServletContext()
					.getResourceAsStream(appConfigLocation.trim()));
		}
	}
}

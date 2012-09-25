/* @(#) OrderController.java
 * Project:	dev-frame
 * Package:	com.qingshiling.web.order
 * Author:	Rainisic
 * Copyright © 2012 by Rain Rhyme Internet Studio. All rights reserved.
 */
package com.qingshiling.web.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Rainisic
 * 
 */
@Controller
@RequestMapping("order")
public class OrderController {

	@RequestMapping("create")
	public String create() {
		return "site.order.create";
	}
}

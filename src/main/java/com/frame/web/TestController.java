package com.frame.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/site")
	public String site(Model model) {
		return "site.test.index";
	}
	
	@RequestMapping("/ajax")
	public String ajax(Model model) {
		return "ajax.test.index";
	}
}

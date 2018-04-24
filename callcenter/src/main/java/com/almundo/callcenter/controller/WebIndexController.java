package com.almundo.callcenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class WebIndexController.
 * produces the public web content.
 * 
 * @version 0.0.1
 */
@Controller
public class WebIndexController {

	/**
	 * Gets the index page.
	 *
	 * @return the index page
	 */
	@RequestMapping(value = "/index")
	public String getIndexPage() {
			return "index";
	}
}

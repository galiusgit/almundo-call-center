package com.almundo.callcenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebIndexController {

	@RequestMapping("/")
	public String getIndexHtmlFile() {
		return "index";
	}
}

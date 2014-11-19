package com.itransition.itransitionproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/page")
public class PageController {

	@RequestMapping(method = RequestMethod.POST)
	public String firstPage(Model model) {
		return "page";
	}
}

package com.spring.series.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 
 * @author 	Lian
 * @date	2016年5月13日
 * @since	1.0	
 */
@Controller
@RequestMapping(value = "/helloworld")
public class HelloWorldController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		System.out.println("access");
		ModelAndView mav = new ModelAndView();
		mav.addObject("messages", "Hello World!!!");
		mav.setViewName("index");

		return mav;
	}
}

package com.spring.series.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 不设置method方法, 默认匹配所有方式的请求
 * 
 * @author 	Lian
 * @date	2016年5月13日
 * @since	1.0	
 */
@Controller
@RequestMapping(value = "/helloworld")
public class HelloWorldController {

	/**
	 * 多个URL映射到同一方法
	 *
	 * @return
	 */
	@RequestMapping(value = { "/index", "/hello" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("messages", "Hello World!!!");
		mav.setViewName("index");

		return mav;
	}

	/**
	 * URL请求参数映射
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ModelAndView getDetail(@PathVariable(value = "id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		mav.setViewName("detail");

		return mav;
	}

	/**
	 * URL通配符映射
	 * ?	一个字符	
	 * *	多个字符
	 * **	0个或多个路径
	 *
	 * @return
	 */
	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public ModelAndView urlTest() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("urlTest");

		return mav;
	}

	/**
	 * URL正则表达式映射
	 *
	 * @return
	 */
	@RequestMapping(value = "/reg/{name:\\w+}-{age:\\d+}", method = RequestMethod.GET)
	public ModelAndView regUrlTest(@PathVariable(value = "name") String name, @PathVariable(value = "age") Integer age) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.addObject("age", age);
		mav.setViewName("regUrlTest");

		return mav;
	}

	/**
	 * 指定映射请求必须包含某参数
	 *
	 * @return
	 */
	@RequestMapping(value = "/paramtest", params = "example", method = RequestMethod.GET)
	public ModelAndView paramTest() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("paramtest");

		return mav;
	}

	/**
	 * 指定映射请求必须不包含某参数
	 *
	 * @return
	 */
	@RequestMapping(value = "/paramtest2", params = "!example", method = RequestMethod.GET)
	public ModelAndView paramTest2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("paramtest2");

		return mav;
	}

	/**
	 * 指定映射请求中或者某参数必须等于某个值
	 *
	 * @return
	 */
	@RequestMapping(value = "/paramtest3", params = "example=AAA", method = RequestMethod.GET)
	public ModelAndView paramTest3() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("paramtest3");

		return mav;
	}

	/**
	 * 指定映射请求中或者某参数必须等于某个值
	 *
	 * @return
	 */
	@RequestMapping(value = "/paramtest4", params = "example!=AAA", method = RequestMethod.GET)
	public ModelAndView paramTest4() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("paramtest4");

		return mav;
	}
}

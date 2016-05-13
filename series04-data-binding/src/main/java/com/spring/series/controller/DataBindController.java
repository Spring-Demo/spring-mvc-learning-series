package com.spring.series.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 数据绑定 Controller
 * 
 * @author 	Lian
 * @date	2016年5月13日
 * @since	1.0	
 */
@Controller
@RequestMapping(value = "/databind")
public class DataBindController {

	@RequestMapping(value = "/paramBind", method = RequestMethod.GET)
	public ModelAndView paramBind() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("paramBind");

		return mav;
	}

	@RequestMapping(value = "/paramBind", method = RequestMethod.POST)
	public ModelAndView paramBind(HttpServletRequest request, @RequestParam(value = "urlParam") String urlParam,
			@RequestParam(value = "formParam") String formParam, @RequestParam(value = "formFile") MultipartFile formFile) {
		// 如果不用注解自动绑定，我们还可以像下面一样手动获取数据
		String urlParam1 = ServletRequestUtils.getStringParameter(request, "urlParam", null);
		String formParam1 = ServletRequestUtils.getStringParameter(request, "formParam", null);
		MultipartFile formFile1 = ((MultipartHttpServletRequest) request).getFile("formFile");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("paramBind");

		return mav;
	}
}

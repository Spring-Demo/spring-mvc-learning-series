package com.spring.series.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.series.model.ValidateModel;

/**
 * Validator Controller
 * 
 * @author 	Lian
 * @date	2016年5月16日
 * @since	1.0	
 */
@Controller
@RequestMapping("/validate")
public class ValidateController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {
		if (!model.containsAttribute("contentModel")) {
			model.addAttribute("contentModel", new ValidateModel());
		}

		return "validatetest";
	}

	@RequestMapping(value = "/test", method = { RequestMethod.POST })
	public String test(Model model, @Valid @ModelAttribute("contentModel") ValidateModel validateModel, BindingResult result)
			throws NoSuchAlgorithmException {

		// 如果有验证错误 返回到form页面
		if (result.hasErrors())
			return test(model);
		return "validatesuccess";
	}
}

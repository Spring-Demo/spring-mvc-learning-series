package com.spring.series.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.series.model.AccountModel;

/**
 * 数据绑定 Controller
 * 
 * @author 	Lian
 * @date	2016年5月13日
 * @since	1.0	
 */
@Controller
@RequestMapping(value = "/databind")
@SessionAttributes(value = "sessionaccountmodel")
public class DataBindController {

	@RequestMapping(value = "/parambind", method = RequestMethod.GET)
	public ModelAndView paramBind() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("parambind");

		return mav;
	}

	@RequestMapping(value = "/parambind", method = RequestMethod.POST)
	public ModelAndView paramBind(HttpServletRequest request, @RequestParam(value = "urlParam") String urlParam,
			@RequestParam(value = "formParam") String formParam, @RequestParam(value = "formFile") MultipartFile formFile) {
		// 如果不用注解自动绑定，我们还可以像下面一样手动获取数据
		String urlParam1 = ServletRequestUtils.getStringParameter(request, "urlParam", null);
		String formParam1 = ServletRequestUtils.getStringParameter(request, "formParam", null);
		MultipartFile formFile1 = ((MultipartHttpServletRequest) request).getFile("formFile");

		ModelAndView mav = new ModelAndView();
		mav.addObject("urlParam", urlParam);
		mav.addObject("formParam", formParam);
		mav.addObject("formFileName", formFile.getOriginalFilename());

		mav.addObject("urlParam1", urlParam1);
		mav.addObject("formParam1", formParam1);
		mav.addObject("formFileName1", formFile1.getOriginalFilename());
		mav.setViewName("parambindresult");

		return mav;
	}

	@RequestMapping(value = "/automodelbind", method = RequestMethod.GET)
	public String modelAutoBind(Model model) {
		model.addAttribute("accountModel", new AccountModel());
		return "modelautobind";
	}

	@RequestMapping(value = "/automodelbind", method = RequestMethod.POST)
	public String modelAutoBind(Model model, AccountModel accountModel) {
		model.addAttribute("accountModel", accountModel);
		return "modelautobindresult";
	}

	@RequestMapping(value = "/automodelbind2", method = RequestMethod.POST)
	public String modelAutoBind2(@ModelAttribute("accountModel") AccountModel accountModel) {
		return "modelautobindresult";
	}

	@RequestMapping(value = "/cookiebind", method = RequestMethod.GET)
	public String cookieBind(Model model, @CookieValue(value = "JSESSIONID", defaultValue = "") String jsessionId) {
		model.addAttribute("jsessionId", jsessionId);

		return "cookiebindresult";
	}

	@RequestMapping(value = "/requestheaderbind", method = RequestMethod.GET)
	public String requestHeaderBind(Model model, @RequestHeader(value = "User-Agent", defaultValue = "") String userAgent) {
		model.addAttribute("userAgent", userAgent);

		return "requestheaderbindresult";
	}

	// @SessionAttributes Test
	@ModelAttribute("sessionaccountmodel")
	public AccountModel initAccountModel() {
		return new AccountModel();
	}

	@RequestMapping(value = "/usernamebind", method = RequestMethod.GET)
	public String usernameBind(Model model) {
		model.addAttribute("sessionaccountmodel", new AccountModel());
		return "usernamebind";
	}

	@RequestMapping(value = "usernamebind", method = RequestMethod.POST)
	public String usernameBindPost(@ModelAttribute("sessionaccountmodel") AccountModel accountModel) {
		// 重定向到密码绑定测试
		return "redirect:passwordbind";
	}

	@RequestMapping(value = "/passwordbind", method = RequestMethod.GET)
	public String passwordBind(@ModelAttribute("sessionaccountmodel") AccountModel accountModel) {
		return "passwordbind";
	}

	@RequestMapping(value = "/passwordbind", method = RequestMethod.POST)
	public String passwordBindPost(@ModelAttribute("sessionaccountmodel") AccountModel accountModel, SessionStatus status) {
		// 销毁@SessionAttributes存储的对象
		status.setComplete();

		return "sessionmodelbindresult";
	}
}

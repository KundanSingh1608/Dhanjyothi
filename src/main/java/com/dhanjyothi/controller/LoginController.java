package com.dhanjyothi.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyothi.bean.Signin;
import com.dhanjyothi.service.LoginService;


@Controller
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	private static final String AUTHENTICATION_SUCCESS = "User has been Authenticated Successfully";
	private static final String AUTHENTICATION_FAILURE = "Error occured while User Authentication.Please try Again or Sign Up";
	@Autowired
	private LoginService loginservice;
	@Autowired
	private HttpSession httpsession;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showRegister() {
		 ModelAndView modelview = new ModelAndView("login");
	        Signin login = new Signin();
	        modelview.addObject("Signin", login);
		return modelview;
	}
	@RequestMapping(value = "/login/submit", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		 ModelAndView modelview = new ModelAndView("login");
	        Signin login = new Signin();
	        modelview.addObject("Signin", login);
		return modelview;
	}

	@RequestMapping(value = "/login/submit", method = RequestMethod.POST)
	public ModelAndView validateUser(@ModelAttribute("Signin") Signin login, HttpServletRequest request, Model model) {
		 ModelAndView modelview = new ModelAndView("login");
		//logs debug message
			if(logger.isDebugEnabled()){
				logger.debug("user Authentication is being executed!");
			}
		int resultsize = loginservice.validateUser(login.getUserName(), login.getPassword());
			modelview.addObject("resultsize", resultsize);
		if(resultsize>0 && resultsize ==1) {
			//modelview.addObject("loginStatus", AUTHENTICATION_SUCCESS);
			logger.info(AUTHENTICATION_SUCCESS);
			return new ModelAndView("redirect:/loadaccount");
		}
		else {
			modelview.addObject("loginStatus", AUTHENTICATION_FAILURE);
			logger.info(AUTHENTICATION_FAILURE+".Please check your credentials.");
		}
		return modelview;
	}

	@RequestMapping("/accsummary")
	public String loadAccSummary(HttpServletRequest request, Model model) {
		return null;
	}

	@RequestMapping("/adduser")
	public String addUser(HttpServletRequest request, Model model) {
		return null;
	}

	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request) {
		httpsession.invalidate();
	    return "redirect:/login";
	}
}

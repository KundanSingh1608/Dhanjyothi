package com.dhanjyothi.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyothi.bean.UserBean;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.RegisterService;
import com.dhanjyothi.validator.UserFormValidator;

@Controller
public class RegisterController {
	private static final Logger logger = Logger.getLogger(RegisterController.class);
	private static final String REGISTRATION_SUCCESS = "User has been Registered Successfully";
	private static final String REGISTRATION_FAILURE = "Error occured while User Registration.Please try Again";
	@Autowired
	private RegisterService registerservice;
	@Autowired
	private UserFormValidator uservalidator;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView showRegister() {
        ModelAndView modelview = new ModelAndView("signup");
        UserBean user = new UserBean();
        modelview.addObject("userBean", user);
		return modelview;
	}

	@RequestMapping(value = "/register/save", method = RequestMethod.POST)
	public ModelAndView saveRegister(@Valid @ModelAttribute("userBean") UserBean userbean, BindingResult bindingResult) {
		long id =0;
		ModelAndView mview = new ModelAndView("signup");
		uservalidator.validate(userbean, bindingResult);
        if(bindingResult.hasErrors()){
        	logger.error("Some form validation failed.Please correct it and proceed again");
            return mview;
        }
		try {
			 id = registerservice.saveRegister(userbean);
			 mview.addObject("resultsize", id);
			 if(id>0) {
			 logger.info("User has been registered succesfully");
			 mview.addObject("registrationMsg", REGISTRATION_SUCCESS);
			 }
			 else {
				mview.addObject("registrationMsg", REGISTRATION_FAILURE);
				logger.error("Error while adding user to database.Please try again.");
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mview.addObject("registrationMsg", REGISTRATION_FAILURE);
			logger.error("Error while adding user to database due to :"+e.getLocalizedMessage());
			e.printStackTrace();
		}
		return mview;
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ModelAndView getAllUsers() {

		return new ModelAndView("");
	}
	@RequestMapping(value = "/userListToBeEnabled", method = RequestMethod.GET)
	public ModelAndView getAllUsersNeedToBeEnabled() {
		logger.info("Fetching users list that needs to be Enabled by admin");
         List<User> lUserDisabled = registerservice.getAllUsersToBeEnabled();
         ModelAndView mview = new ModelAndView("admin");
         mview.addObject("listUsers", lUserDisabled);
		return mview;
	}
	@RequestMapping(value = "/register/enableUser", method = RequestMethod.POST)
	public String enableUser(@RequestParam(name = "userToBeEnabled") String userToBeEnabled) {
		System.out.println("user to be enabled are:"+userToBeEnabled);
		try {
			registerservice.enableUsers(userToBeEnabled);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return"redirect:/userListToBeEnabled";
	}
}

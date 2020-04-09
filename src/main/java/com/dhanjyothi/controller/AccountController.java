package com.dhanjyothi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.AccountService;

@Controller
public class AccountController {
	private static final Logger logger = Logger.getLogger(AccountController.class);
    @Autowired
	private AccountService accountservice;
    @Autowired
    private HttpSession httpsession;
	@GetMapping("/createsavingsaccount")
	public ModelAndView loadAccountCreationPage(Model model, HttpServletRequest request) {
		ModelAndView mview = new ModelAndView("redirect:/loadaccount");
		if(httpsession.getAttribute("userId") ==null)
		{
			return new ModelAndView("redirect:login");
		}
		int userId = (int) httpsession.getAttribute("userId");
		 try {
				User user = accountservice.getUserById(userId);
			accountservice.openSavingsAccount(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Unable to create saving account due to :"+e.getMessage());
			e.printStackTrace();
		};
return mview;
	}

	@GetMapping("/loadaccount")
	public ModelAndView loadSavingAccount(@ModelAttribute("account1") Account account, Model model,HttpServletRequest request) {
		ModelAndView mview = new ModelAndView("accountsummary");
		if(httpsession.getAttribute("userId") ==null)
		{
			return new ModelAndView("redirect:login");
		}
		int userId = (int) httpsession.getAttribute("userId");
		char accountType ='S';
		char accountType_Term = 'T';
		try {
			mview.addObject("savingAccount", accountservice.getAccountDetails(userId, accountType));
			mview.addObject("termAccounts", accountservice.getAccountDetails(userId, accountType_Term));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error occured while getting saving Account: due to "+e.getLocalizedMessage());
			e.printStackTrace();
		}
		return mview;
	}
	
	@GetMapping("/loadtermaccount")
	public String loadTermAccount(@ModelAttribute("account1") Account account1, Model model) {
		if(httpsession.getAttribute("userId") ==null)
		{
			return "redirect:login";
		}
		Account account = new Account();
		model.addAttribute("account", account);
		return "termaccount";
	}

	@PostMapping("/createtermaccount")
	public ModelAndView createTermAccount(@ModelAttribute("account") Account account, Model model, HttpServletRequest request,
			BindingResult bindingResult) {
		ModelAndView mview = new ModelAndView("redirect:/loadaccount");
		if(httpsession.getAttribute("userId") ==null)
		{
			return new ModelAndView("redirect:login");
		}
		int userId = (int) httpsession.getAttribute("userId");
		 try {
				User user = accountservice.getUserById(userId);
			accountservice.openTermAccount(account,user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Unable to create Term Deposit account due to :"+e.getMessage());
			e.printStackTrace();
		};
return mview;
	}

	@GetMapping("/viewtransactions")
	public ModelAndView loadTransactionDetails(HttpServletRequest request,@RequestParam String ac_Id) {
		ModelAndView mview = new ModelAndView("transaction");
		if(httpsession.getAttribute("userId") ==null)
		{
			return new ModelAndView("redirect:login");
		}
		  int userId = (int) httpsession.getAttribute("userId"); //char accountType ='S';
		  try { //Account account = accountservice.getAccountDetails(userId,accountType);
		  int accId = Integer.parseInt(ac_Id); 
		  List<Transaction> lTransaction = accountservice.loadAllTransactions(userId);
		  mview.addObject("listTransaction",lTransaction); 
		  } catch (Exception e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }
		 
		return mview;
	}
	@GetMapping("/admin")
	public ModelAndView loadAdmin(HttpServletRequest request) {
		ModelAndView mview = new ModelAndView("redirect:userListToBeEnabled");
		/*
		 * if(httpsession.getAttribute("userId") ==null) { return new
		 * ModelAndView("redirect:login"); }
		 */
		return mview;
	}
	@GetMapping("/403")
	public ModelAndView loadAccessDenied(HttpServletRequest request) {
		ModelAndView mview = new ModelAndView("403");
		/*
		 * if(httpsession.getAttribute("userId") ==null) { return new
		 * ModelAndView("redirect:login"); }
		 */
		return mview;
	}
}

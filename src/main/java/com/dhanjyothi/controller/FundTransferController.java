package com.dhanjyothi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Beneficiaries;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.service.AccountService;

@Controller
public class FundTransferController {
	private static final Logger logger = Logger.getLogger(FundTransferController.class);
	@Autowired
	private AccountService accountservice;
    @Autowired
    private HttpSession httpsession;
	@GetMapping("/loadbeneficiary")
	public ModelAndView loadBeneficiaryPage() {
		ModelAndView mview = new ModelAndView("addbeneficiary");
		Beneficiaries beneficiaries = new Beneficiaries();
		mview.addObject("beneficiary", beneficiaries);
		return mview;
	}
	
	static final char accountType ='S';
	@GetMapping("/loadtransfer")
	public ModelAndView loadTransferPage(
			HttpServletRequest request) {
		Account account;
		ModelAndView mview = new ModelAndView("transfer");
		if(httpsession.getAttribute("userId") ==null)
		{
			return new ModelAndView("redirect:login");
		}
		int userId = (int) httpsession.getAttribute("userId");
		Transaction transaction = new Transaction();
		mview.addObject("transaction", transaction);
		try {
			account = accountservice.getAccountDetails(userId, accountType);
			mview.addObject("beneficiaryList", accountservice.getAllBeneficiaries(userId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mview;
	}
//
	@GetMapping("/beneficiarywithinbank")
	public String beneficiarywithinbank(@ModelAttribute("beneficiary") Beneficiaries beneficiary, Model model) {
		if(httpsession.getAttribute("userId") ==null)
		{
			return "redirect:login";
		}
		return "beneficiarytype";
	}

	@GetMapping("/beneficiaryotherbank")
	public String beneficiaryotherbank(@ModelAttribute("beneficiary") Beneficiaries beneficiary, Model model) {

		return null;
	}

	@PostMapping("/savebeneficiary")
	public ModelAndView saveBeneficiary(@Valid @ModelAttribute("beneficiary") Beneficiaries beneficiary,
			BindingResult bindingResult, HttpServletRequest request) {
		ModelAndView mview =new ModelAndView("beneficiarytype");
		if(httpsession.getAttribute("userId") ==null)
		{
			return new ModelAndView("redirect:login");
		}
		int userId = (int) httpsession.getAttribute("userId");
		beneficiary.setUserId(userId);
		 if(bindingResult.hasErrors()){
	        	logger.error("Some form validation failed.Please correct it and try again");
	            return mview;
	        }
		try {
			Account accountcheck = accountservice.checkAccountExists(beneficiary.getBenAccountNumber().intValue());
			Account account = accountservice.getAccountDetails(beneficiary.getBenAccountNumber().intValue());
			if(accountcheck !=null) {
			accountservice.saveBeneficiaries(account, beneficiary);
			return new ModelAndView("redirect:loadaccount");
			}
			else{
				mview.addObject("accountMissing", "Account Num Provided do not exists. Please provide valid input.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mview;
	}

	@PostMapping("/transferamt")
	public ModelAndView transferAmount(@Valid @ModelAttribute("transaction") Transaction transaction,
			BindingResult bindingResult, HttpServletRequest request) {
		ModelAndView mview =new ModelAndView("redirect:loadtransfer");
		 if(bindingResult.hasErrors()){
	        	logger.error("Some form validation failed.Please correct it and try again");
	            return mview;
	        }
		 if(httpsession.getAttribute("userId") ==null)
			{
				return new ModelAndView("redirect:login");
			}
		Account fromAccount;
		Account toAccount;
		int userId = (int) httpsession.getAttribute("userId");
		try {
			fromAccount = accountservice.getAccountDetails(userId, accountType);
			toAccount = accountservice.getAccountDetails(transaction.getBenefeciaryId());
			accountservice.updateFromAccount(fromAccount, transaction.getTransactionAmount(), transaction,toAccount);
			accountservice.updateToAccount(toAccount, transaction.getTransactionAmount(), transaction,fromAccount);
			return new ModelAndView("redirect:loadaccount");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mview;
	}
}

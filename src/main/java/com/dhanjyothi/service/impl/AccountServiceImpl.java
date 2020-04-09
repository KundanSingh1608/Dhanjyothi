package com.dhanjyothi.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanjyothi.dao.AccountDao;
import com.dhanjyothi.dao.RegisterDao;
import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Beneficiaries;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.AccountService;
import com.dhanjyothi.util.TransactionEnum;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountdao;
	@Autowired
	private RegisterDao registerdao;
	@Autowired
	private HttpSession httpsession;
	@Autowired
	private AccountService accountservice;
	public Account getAccountDetails(int userId, Character accountType) throws Exception {
		return accountdao.getAccountDetails(userId, accountType);
	}

	public void openSavingsAccount(User user) throws Exception {
	Boolean	isSavingsAccountExists = Boolean.FALSE;
	Account account = new Account();
	 Date date = new Date();  
	account.setAccountBalance(10000);
	account.setAccountCreatedDate(new Timestamp(date.getTime()));
	account.setAccountUpdatedDate(new Timestamp(date.getTime()));
	account.setAccountStatus('A');
	account.setAccountType('S');
	account.setAccountholder(user);
	 if(account.getId() != null) {
		 isSavingsAccountExists = Boolean.TRUE;
	 }
	 accountdao.openSavingsAccount(account, isSavingsAccountExists);
	}

	public void openTermAccount(Account account, User user) throws Exception {
		Date date = new Date();  
		account.setAccountBalance(10000);
		account.setAccountCreatedDate(new Timestamp(date.getTime()));
		account.setAccountUpdatedDate(new Timestamp(date.getTime()));
		account.setAccountStatus('A');
		account.setAccountType('T');
		account.setAccountholder(user);
		account.setInterestRate(calculateInterestRate(account.getMaturityAmount(), account.getAccountTenure()));
		 if(account.getId() != null) {
		 }
		 accountdao.openTermAccount(account);
		Account fromAccount = accountservice.getAccountDetails(user.getId(), 'S');
		Transaction transaction = new Transaction();
		transaction.setTransactionDesc("Self Transfer Term Account Creation");
		transaction.setTransactionAmount(account.getMaturityAmount());
		transaction.setTransactionDate(date);
		accountservice.updateFromAccount(fromAccount, transaction.getTransactionAmount(), transaction,fromAccount);
		}
 private double calculateInterestRate(long amount,int tenure) {
	 if(amount <100000) {
		 if(tenure==1||tenure==2||tenure==3)return 5.75;
		 else if(tenure==4 ||tenure==5) return 6.00;
	 }
	 else if(amount <1000000) {
		 if(tenure==1||tenure==2)return 6.00;
		 else if(tenure==4 ||tenure==3) return 6.25;
		 else if(tenure==5)return 6.50;
	 }
	 else if(amount <=10000000) {
		 if(tenure==1)return 6.25;
		 else if(tenure==2)return 6.50;
		 else if(tenure==4 ||tenure==3) return 6.75;
		 else if(tenure==5)return 7.00;
	 }
	return 0;
	 
 }
	public List<Account> getTermAccountDetails(int userId, String accountType) throws Exception {
		return null;
	}

	public Map<Integer, String> getTenureDetails() {
		return null;
	}

	public boolean checkSavingsAccBalance(long termAmt) throws Exception {
		return true;
	}

	public void updateSavingsAccount(Account account, User cust) throws Exception {
		Date today = new Date();
		account.setAccountUpdatedDate(new Timestamp(today.getTime()));
		account.setAccountholder(cust);
		boolean isSavingsAccountExists = account.getId() !=null?true:false;
		accountdao.openSavingsAccount(account, isSavingsAccountExists );
	}

	public User getUserDetails(User user) throws Exception {
		return null;
	}

	public void saveBeneficiaries(Account account, Beneficiaries beneficiaries) throws Exception {
		beneficiaries.setOwner_id(account);
		beneficiaries.setBenType('I');
		accountdao.saveBeneficiaries(beneficiaries);
	}

	public boolean checkAccountExists(Beneficiaries beneficiaries) throws Exception {
		return true;
	}

	public List<Beneficiaries> getAllBeneficiaries(int accountId) throws Exception {
		return accountdao.getAllBeneficiaries(accountId);
	}

	public void updateFromAccount(Account account, long transAmt, Transaction transaction1, Account toAccount) throws Exception {
		User user = registerdao.getUserByUserId((int) httpsession.getAttribute("userId"));
		Date date = new Date();
		long newamount = account.getAccountBalance()-transAmt;
		account.setAccountBalance(newamount);
		updateSavingsAccount(account, user);
		Transaction transaction= new Transaction();
		transaction.setBenefeciaryId(transaction1.getBenefeciaryId());
		transaction.setTransactionDesc(transaction1.getTransactionDesc());
		transaction.setTransactionAmount(transaction1.getTransactionAmount());
		transaction.setCREDIT_ACCT(toAccount);
		transaction.setDEBIT_ACCT(account);
		transaction.setTransactionAmount(transAmt);
		transaction.setTransactionDate(new Timestamp(date.getTime()));
		transaction.setTransactionType(TransactionEnum.DEBIT.getKey());
		transaction.setUserId(user.getId().toString());
		accountdao.updateTransactionDetails(transaction);
	}

	public void updateToAccount(Account account, long transAmt,Transaction transaction1,Account fromAccount) throws Exception {
		Date date = new Date();
		User user = registerdao.getUserByUserId(account.getAccountholder().getId());
		long newamount = account.getAccountBalance()+transAmt;
		account.setAccountBalance(newamount);
		updateSavingsAccount(account, user);
		Transaction transaction= new Transaction();
		transaction.setBenefeciaryId(transaction1.getBenefeciaryId());
		transaction.setTransactionDesc(transaction1.getTransactionDesc());
		transaction.setTransactionAmount(transaction1.getTransactionAmount());
		transaction.setCREDIT_ACCT(account);
		transaction.setDEBIT_ACCT(fromAccount);
		transaction.setTransactionAmount(transAmt);
		transaction.setTransactionDate(new Timestamp(date.getTime()));
		transaction.setTransactionType(TransactionEnum.CREDIT.getKey());
		transaction.setUserId(user.getId().toString());
		accountdao.updateTransactionDetails(transaction);
	}

	public List<Transaction> loadAllTransactions(int accId) throws Exception {
		return accountdao.loadAllTransactions(accId);
	}

	public boolean isUserNameExists(String name) throws Exception {
		return true;
	}

	public Account checkAccountExists(int accountId) throws Exception {
		return accountdao.checkAccountExists(accountId);

	}

	public User getUserById(int userId) throws Exception {
		return accountdao.getUserById(userId);
	}

	@Override
	public Account getAccountDetails(int accountId) throws Exception {
		return accountdao.getAccountDetails(accountId);
	}
}

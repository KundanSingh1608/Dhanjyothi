package com.dhanjyothi.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhanjyothi.dao.AccountDao;
import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Beneficiaries;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.model.User;

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {
	private static final Logger logger = Logger.getLogger(AccountDaoImpl.class);
	@Autowired
	private SessionFactory sessionfactory;
	@SuppressWarnings({ "rawtypes", "unchecked"})
	public Account getAccountDetails(int userId, Character accountType) throws Exception {
		Session session = sessionfactory.getCurrentSession();
		logger.info("Fetching Account info using Hibernate HQL ....");
		Account account = null;
		/*
		 * Criteria cr = session.createCriteria(Account.class); Criterion type =
		 * Restrictions.eq("accountType", accountType); Criterion user_id =
		 * Restrictions.eq("accountholder",userId); // To get records matching with AND
		 * conditions LogicalExpression andExp = Restrictions.and(type, user_id);
		 * cr.add( andExp );
		 */
		Query query = session.createNamedQuery("HQL_ACCOUNT_BY_ID");	
		List<Object[]> accountlist =  query.setParameter("accountid", userId)
				.setParameter("accountType", accountType).list();
		for (Object[] aRow : accountlist) {
		    account = (Account) aRow[0];
		}
		return account;
	}

	public void openSavingsAccount(Account account, boolean isSavingsAccountExists) throws Exception {
    if(isSavingsAccountExists) {
    	sessionfactory.getCurrentSession().update(account);
    }
    else {
    	sessionfactory.getCurrentSession().save(account);
    }
	}

	public void openTermAccount(Account account) throws Exception {
		sessionfactory.getCurrentSession().save(account);
	}

	public List<Account> getTermAccountDetails(int userId, String accountType) throws Exception {

		return null;
	}

	public User getUserDetails(User user) throws Exception {

		return null;
	}

	public void saveBeneficiaries(Beneficiaries beneficiaries) throws Exception {
		Session session = sessionfactory.getCurrentSession();
		logger.info("In saveBeneficiaries method.Going to persist Beneficiaries in db");
		session.persist(beneficiaries);
	}

	public Account checkAccountExists(int accountId) throws Exception {
		Session session = sessionfactory.getCurrentSession();
		Account account = null;
		Criteria cr = session .createCriteria(Account.class); 
		Criterion criteria = Restrictions.eq("id", accountId);
		cr.add(criteria);
		List<Account> laccount = cr.list();
		for(Account accnt : laccount) {
			account = accnt;
		}
		return account;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Beneficiaries> getAllBeneficiaries(int accountId) throws Exception {
		List<Beneficiaries> benefeciaryList = new ArrayList<>();
		
		  Session session = sessionfactory.getCurrentSession();
		Criteria cr = session .createCriteria(Beneficiaries.class,"beneficiaries"); 
		//cr.setFetchMode("beneficiaries.owner_id", FetchMode.JOIN);
		//cr.createAlias("beneficiaries.owner_id", "account"); // inner join by default
		Criterion type = Restrictions.eq("userId", accountId); 
		 cr.add(type);
		benefeciaryList =  cr.list();
		return benefeciaryList;
	}

	public void updateTransactionDetails(Transaction transaction) throws Exception {
          sessionfactory.getCurrentSession().saveOrUpdate(transaction);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Transaction> loadAllTransactions(int accountId) throws Exception {
        List<Transaction> listTransaction = new ArrayList<>();
        Session session = sessionfactory.getCurrentSession();
		Criteria cr = session .createCriteria(Transaction.class,"transaction"); 
		cr.setFetchMode("transaction.DEBIT_ACCT", FetchMode.JOIN);
		cr.setFetchMode("transaction.CREDIT_ACCT", FetchMode.JOIN);
		cr.createAlias("transaction.DEBIT_ACCT", "debit");// inner join by default
		cr.createAlias("transaction.CREDIT_ACCT", "credit");
		/*
		 * Criterion debit_accountId = Restrictions.eq("debit.id", accountId); Criterion
		 * credit_accountId = Restrictions.eq("credit.id", accountId); LogicalExpression
		 * andExp = Restrictions.or(debit_accountId, credit_accountId);
		 */
		Criterion user_Id = Restrictions.eq("userId",accountId+"");
		 cr.add( user_Id );
		 cr.addOrder(Order.desc("transactionDate"));
		 Projection projection = Projections.property("id"); 
		 Projection projection2 = Projections.property("transactionDesc"); 
		 Projection projection3 = Projections.property("transactionAmount"); 
		 Projection projection4 = Projections.property("transactionType"); 
		 ProjectionList pList = Projections.projectionList(); 
		 pList.add(projection); 
		 pList.add(projection2); 
		 pList.add(projection3); 
		 pList.add(projection4);
		 cr.setProjection(pList); 
		 List<Object[]> crList = cr.list();
		 for(Object[] criteria : crList) {
			Transaction transaction = new Transaction();
			transaction.setId((Integer) criteria[0]);
			transaction.setTransactionDesc((String) criteria[1]);
			transaction.setTransactionAmount((Long) criteria[2]);
			transaction.setTransactionType((String) criteria[3]);
			listTransaction.add(transaction);
		 }
		return listTransaction;
	}

	public User isUserNameExists(String userName) throws Exception {

		return null;
	}

	public User getUserById(int userId) throws Exception {

		return (User) sessionfactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("id", userId)).uniqueResult();
	}

	@Override
	public Account getAccountDetails(int accountId) throws Exception {
		Session session = sessionfactory.getCurrentSession();
		  Criteria cr = session.createCriteria(Account.class);
		  Criterion type = Restrictions.eq("id", accountId); 
		  cr.add( type );
		  Account account =null;
		 List<Account> accounts = cr.list();
		 for(Account acount:accounts) {
			 account = acount;
		 }
		return account;
	}

}

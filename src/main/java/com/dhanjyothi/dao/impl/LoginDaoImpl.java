package com.dhanjyothi.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dhanjyothi.dao.LoginDao;
import com.dhanjyothi.model.User;
import com.dhanjyothi.util.AESEncryptionUtil;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {
	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);
	@Autowired
	private SessionFactory sessionfactory;
	@Autowired
	private HttpSession httpsession;
	private static String secretKey = "boooooooooom!!!!";
	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Override
	public int validateUser(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.getCurrentSession();
		logger.info("Quering User using Hibernate criteria .");
		Criteria cr = session.createCriteria(User.class);
		Criterion username1 = Restrictions.eq("userName", username);
		Criterion password1 = Restrictions.eq("password",AESEncryptionUtil.encrypt(password, secretKey));
		// To get records matching with AND conditions
		LogicalExpression andExp = Restrictions.and(username1, password1);
		cr.add( andExp );

		@SuppressWarnings("unchecked")
		List<User> results = (List<User>)cr.list();
		for(User user:results) {httpsession.setAttribute("userName", user.getFirstName()+" "+user.getLastName());
		httpsession.setAttribute("userId", user.getId().intValue());
		}
		return results.size();
	}
}
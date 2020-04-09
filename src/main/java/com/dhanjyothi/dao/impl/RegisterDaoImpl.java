package com.dhanjyothi.dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dhanjyothi.dao.RegisterDao;
import com.dhanjyothi.model.UploadFile;
import com.dhanjyothi.model.User;
import com.dhanjyothi.model.UserRoles;

@Repository
@Transactional
public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	private SessionFactory sessionfactory;
	@Autowired
	private HttpSession httpsession;
	public long saveRegister(User customer) throws Exception{
		long id =0;
		Session session = sessionfactory.getCurrentSession();
		Integer numret =(Integer) session.save(customer);
		 id = numret.longValue();
		return id;
	}

	public List<User> getAllUsers() {
		return null;
	}

	@Override
	public void uploadUserDocument(UploadFile file) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionfactory.getCurrentSession();
		 session.persist(file);
	}

	@SuppressWarnings("deprecation")
	public User getUserByUserId(int userId) throws Exception{
		Session session = sessionfactory.getCurrentSession();
		Criteria cr = session.createCriteria(User.class);
		Criterion criterion = Restrictions.eq("id", userId);
		cr.add( criterion );

		@SuppressWarnings("unchecked")
		List<User> results = (List<User>)cr.list();
		for(User user:results) {
			return user;
		}
		return null;
		
	}

	@Override
	public User findUserByUsername(String username) {
		return sessionfactory.getCurrentSession().get(User.class, (int)httpsession.getAttribute("userId"));
	}

	@Override
	public UserRoles getUserRoleById(int role_id) {
		UserRoles role =  sessionfactory.getCurrentSession().get(UserRoles.class, role_id);
		return role;
	}

	@Override
	public List<User> getUsersToBeEnabled() {
		Session session = sessionfactory.getCurrentSession();
		Criteria cr = session.createCriteria(User.class);
		Criterion criterion = Restrictions.eq("enabled", Boolean.FALSE);
		cr.add( criterion );

		@SuppressWarnings("unchecked")
		List<User> results = (List<User>)cr.list();
		
		return results;
	}

	@Override
	public void enableUser(User user) throws Exception {
		Session session = sessionfactory.getCurrentSession();
		session.update(user);
		
	}
}

package com.dhanjyothi.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanjyothi.dao.LoginDao;
import com.dhanjyothi.service.LoginService;
import com.dhanjyothi.util.AESDecryptionUtil;

@Service
public class LoginServiceImpl implements LoginService {
	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	private LoginDao logindao;
	@Override
	public int validateUser(String username, String password) {
		// TODO Auto-generated method stub
		logger.info("Calling loginDao validate user.");
		//String dec_password = AESDecryptionUtil.decrypt(password, secretKey);
		return logindao.validateUser(username, password);
	}

}

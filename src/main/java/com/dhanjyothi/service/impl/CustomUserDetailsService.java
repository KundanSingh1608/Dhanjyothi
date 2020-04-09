/**
 * 
 */

package com.dhanjyothi.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dhanjyothi.dao.RegisterDao;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.LoginService;
import com.dhanjyothi.util.AESDecryptionUtil;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private RegisterDao userDetailsDao;
	@Autowired
    private LoginService loginService;
	@Transactional(readOnly = true)

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String password = request.getParameter("password"); // get from request parameter
        User user = null;
        if(loginService.validateUser(username, password)==1) {
        	
		 user = userDetailsDao.findUserByUsername(username);
        }
		UserBuilder builder = null;
		if (user != null) {
            String hashpassword = AESDecryptionUtil.decrypt(user.getPassword(), "ssshhhhhhhhhhh!!!!");
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.disabled(!user.isEnabled());
			builder.password(BCrypt.hashpw(hashpassword, BCrypt.gensalt(10)));
			String[] authorities = new String[] {user.getUserRoles().getRole_desc()};

			builder.authorities(authorities);
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();
	}
}

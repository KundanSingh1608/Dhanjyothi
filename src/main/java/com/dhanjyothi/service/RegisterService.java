package com.dhanjyothi.service;

import java.util.List;

import com.dhanjyothi.bean.UserBean;
import com.dhanjyothi.model.UploadFile;
import com.dhanjyothi.model.User;



public interface RegisterService {

	public long saveRegister(UserBean user) throws Exception;
	public void uploadUserDocument(UploadFile file) throws Exception;
	public List<User> getAllUsers();
	public List<User> getAllUsersToBeEnabled();
	public void enableUsers(String ids) throws Exception;
}

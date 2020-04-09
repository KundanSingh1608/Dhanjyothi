package com.dhanjyothi.dao;

import java.util.List;

import com.dhanjyothi.model.UploadFile;
import com.dhanjyothi.model.User;
import com.dhanjyothi.model.UserRoles;

public interface RegisterDao {
	public long saveRegister(User user) throws Exception;
    public void uploadUserDocument(UploadFile file) throws Exception;
	public List<User> getAllUsers();
	public User getUserByUserId(int userId) throws Exception;
	public User findUserByUsername(String username);
	public UserRoles getUserRoleById(int id);
	public List<User> getUsersToBeEnabled();
	public void enableUser(User user)throws Exception;
}

package com.dhanjyothi.service.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dhanjyothi.bean.UserBean;
import com.dhanjyothi.dao.RegisterDao;
import com.dhanjyothi.model.UploadFile;
import com.dhanjyothi.model.User;
import com.dhanjyothi.model.UserRoles;
import com.dhanjyothi.service.RegisterService;
import com.dhanjyothi.util.AESEncryptionUtil;

@Service
public class RegisterServiceImpl implements RegisterService {

	private static final String AADHAR_CARD="Aadhar";
	private static final String PAN_CARD="Pan";
	private static final String IDENTITY_CARD="Identity";
	private static String secretKey = "boooooooooom!!!!";
	List<UploadFile> filesList = new ArrayList<>();
	Set<UploadFile>  attchmentset = new HashSet<>();
	@Autowired
	private RegisterDao registerDao;

	public List<User> getAllUsers() {
		return null;
	}

	@Override
	public long saveRegister(UserBean userbean) throws Exception {
		User user = transformToUser(userbean);
		// TODO Auto-generated method stub
		long id = registerDao.saveRegister(user);
		/*
		 * filesList.forEach(file -> { try { uploadUserDocument(file); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); } });
		 */	
		return id;
	}

	public User transformToUser(UserBean userbean) {
		User user = new User();
		
		user.setAadhar(userbean.getAadhar());
		user.setAddress1(userbean.getAddress1());
		user.setAddress2(userbean.getAddress2());
		user.setCity(userbean.getCity());
		user.setConfirmPassword(encryptPassword(userbean.getConfirmPassword()));
		user.setDob(parseStringToDate(userbean.getDob()));
		user.setEmail(userbean.getEmail());
		user.setFirstName(userbean.getFirstName());
		user.setLastName(userbean.getLastName());
		user.setMobileNumber(userbean.getMobileNumber());
		user.setPan(userbean.getPan());
		user.setPassword(encryptPassword(userbean.getPassword()));
		user.setPinCode(userbean.getPinCode());
		user.setState(userbean.getState());
		user.setUserName(userbean.getUserName());
		if(userbean.getAadharProof()!=null) {
			attchmentset.add(returnFile(userbean.getAadharProof(),AADHAR_CARD,user));
			filesList.add(returnFile(userbean.getAadharProof(),AADHAR_CARD,user));
		}
		if(userbean.getPanProof()!=null) {
			attchmentset.add(returnFile(userbean.getPanProof(),PAN_CARD,user));
			filesList.add(returnFile(userbean.getPanProof(),PAN_CARD,user));
		}
		if(userbean.getAddressProof()!=null) {
			attchmentset.add(returnFile(userbean.getAddressProof(),IDENTITY_CARD,user));
			filesList.add(returnFile(userbean.getAddressProof(),IDENTITY_CARD,user));
		}
		user.setAttachments(attchmentset);
		int roleId = Integer.parseInt(userbean.getUserRole());
		if(roleId ==1) {user.setEnabled(Boolean.TRUE);}
		UserRoles userRoles = prepareRolesObject(roleId);
		user.setUserRoles(userRoles);
		return user;		
	}

	public UploadFile returnFile(MultipartFile multipartfile,String docaCtegory,User user) {
		UploadFile file = new UploadFile();
		try {
			file.setData(multipartfile.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		file.setFileCategory(docaCtegory);
		file.setFileName(multipartfile.getOriginalFilename());
		file.setFileType(multipartfile.getContentType());
		file.setUser(user);
		return file;
	}
	@Override
	public void uploadUserDocument(UploadFile file) throws Exception {
		// TODO Auto-generated method stub
		registerDao.uploadUserDocument(file);
	}
	public String encryptPassword(String password) {
		
		return AESEncryptionUtil.encrypt(password, secretKey);
		
	}
	public LocalDate parseStringToDate(String date) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MM-yyyy");
		LocalDate random = LocalDate.parse(date, df);
		return random;		
	}
	
	private UserRoles prepareRolesObject(int id) {
		UserRoles roles = registerDao.getUserRoleById(id);
		return roles;
	}

	@Override
	public List<User> getAllUsersToBeEnabled() {
		// TODO Auto-generated method stub
		return registerDao.getUsersToBeEnabled();
	}

	@Override
	public void enableUsers(String ids) throws Exception {
		String[] arrId = ids.split(",");
		for(String id:arrId) {
			User user_fetched = registerDao.getUserByUserId(Integer.parseInt(id)); 
			user_fetched.setEnabled(Boolean.TRUE);
			registerDao.enableUser(user_fetched);
		}
		
	}
}

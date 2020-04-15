 package com.dhanjyothi.validator;

/*
 *  @author KundanSingh
 *  
 *  */
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dhanjyothi.bean.UserBean;


@Component
public class UserFormValidator implements Validator {
	private static final String AADHAR_INVALID="Invalid Aadhar Number";
	private static final String PAN_INVALID="Invalid Pan Number";
	private static final String EMAIL_INVALID="Invalid Email";
   @Override
   public boolean supports(Class<?> clazz) {
      return UserBean.class.equals(clazz);
   }

   @Override
   public void validate(Object obj, Errors err) {

      ValidationUtils.rejectIfEmpty(err, "firstName", "NotEmpty.userBean.firstName");
      ValidationUtils.rejectIfEmpty(err, "lastName", "NotEmpty.userBean.lastName");
      ValidationUtils.rejectIfEmpty(err, "dob", "NotEmpty.userBean.dob");
      ValidationUtils.rejectIfEmpty(err, "address1", "NotEmpty.userBean.address");
      ValidationUtils.rejectIfEmpty(err, "city", "NotEmpty.userBean.city");
      ValidationUtils.rejectIfEmpty(err, "state", "NotEmpty.userBean.state");
      ValidationUtils.rejectIfEmpty(err, "pinCode", "NotEmpty.userForm.pin");
      ValidationUtils.rejectIfEmpty(err, "mobileNumber", "NotEmpty.userBean.number");
      ValidationUtils.rejectIfEmpty(err, "aadhar", "Valid.userForm.aadhar");
      ValidationUtils.rejectIfEmpty(err, "email", "NotEmpty.userBean.email");
      ValidationUtils.rejectIfEmpty(err, "pan", "Valid.userForm.pan");
      ValidationUtils.rejectIfEmpty(err, "userName", "NotEmpty.userBean.userName");
      ValidationUtils.rejectIfEmpty(err, "password", "NotEmpty.userBean.password");
      ValidationUtils.rejectIfEmpty(err, "confirmPassword", "NotEmpty.userBean.password");

      UserBean user = (UserBean) obj;

      Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);
      if (!(pattern.matcher(user.getEmail()).matches())) {
         err.rejectValue("email", "email.invalid",EMAIL_INVALID);
      }
      
		
		  Pattern panPattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
		  
		  if (!(panPattern.matcher(user.getPan()).matches())) { err.rejectValue("pan",
		  "userBean.pan.invalid",PAN_INVALID); }
		 
      
		
		  Pattern aadharPattern = Pattern.compile("^\\d{4}\\s\\d{4}\\s\\d{4}$");
		  boolean validAdhar = true;
		  if (!(Pattern.compile("^\\d{12}$").matcher(user.getAadhar()).matches())) {
			  err.rejectValue("aadhar", "userBean.aadhar.invalid",AADHAR_INVALID);   
			  validAdhar=false;
		  }
			  
		  else {
			 if(!(aadharPattern.matcher(user.getAadhar()).matches()) && !validAdhar)
				 err.rejectValue("aadhar", "userBean.aadhar.invalid",AADHAR_INVALID); 
			 }
		 
		/*
		 * String password = user.getPassword(); String confPassword =
		 * user.getConfirmPassword(); if(!password.equals(confPassword)){
		 * err.rejectValue("password","Diff.userform.confirmPassword"); }
		 */
   }

}
/**
 * 
 */
package com.dhanjyothi.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.dhanjyothi.validator.PasswordMatches;
import com.dhanjyothi.validator.ValidPassword;

/**
 * @author GunjanKumar
 *
 */
@PasswordMatches
public class UserBean {
	@Pattern(regexp="[^0-9]*",message = "Only Alphabets allowed")
	private String firstName;
	@Pattern(regexp="[^0-9]*",message = "Only Alphabets allowed")
	private String lastName;
	private String dob;
	private String address1;
	private String address2;
	@Pattern(regexp="[^0-9]*",message = "Only Alphabets allowed")
	private String city;
	@Pattern(regexp="[^0-9]*",message = "Only Alphabets allowed")
	private String state;
	@Size(min = 6,message = "Max characters allowed is 6")
	private String pinCode;
	@Size(max = 10,message = "Max character allowed is 10")
	private String mobileNumber;
	private String email;
	private String aadhar;
	private String pan;
	@Size(min=8,max=15,message = "User Name should be of 8 to 15 chars")
	private String userName;
	@Size(min=8,max=15,message = "Password should be of 8 to 15 characters")
	@ValidPassword
	private String password;
	@Size(min=8,max=15,message = "Password should be of 8 to 15 chars")
	@ValidPassword
	private String confirmPassword;
	private MultipartFile dobProof;
	private MultipartFile addressProof;
	private MultipartFile aadharProof;
	private MultipartFile panProof;
	private String userRole;
	
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public MultipartFile getDobProof() {
		return dobProof;
	}
	public void setDobProof(MultipartFile dobProof) {
		this.dobProof = dobProof;
	}
	public MultipartFile getAddressProof() {
		return addressProof;
	}
	public void setAddressProof(MultipartFile addressProof) {
		this.addressProof = addressProof;
	}
	public MultipartFile getAadharProof() {
		return aadharProof;
	}
	public void setAadharProof(MultipartFile aadharProof) {
		this.aadharProof = aadharProof;
	}
	public MultipartFile getPanProof() {
		return panProof;
	}
	public void setPanProof(MultipartFile panProof) {
		this.panProof = panProof;
	}
	@Override
	public String toString() {
		return "UserBean [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", pinCode=" + pinCode
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", aadhar=" + aadhar + ", pan=" + pan
				+ ", userName=" + userName + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", dobProof=" + dobProof + ", addressProof=" + addressProof + ", aadharProof=" + aadharProof
				+ ", panProof=" + panProof + "]";
	}
	
	
}

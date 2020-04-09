package com.dhanjyothi.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Past;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="USER_DETAILS",schema = "kundan")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5655734095580591341L;
	
	public User() {}
	public User(String firstName, String lastName, LocalDate dob, String address1, String address2, String city,
			String state, String pinCode, String mobileNumber, String email, String aadhar, String pan, String userName,
			String password, String confirmPassword, Set<UploadFile> attachments) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.aadhar = aadhar;
		this.pan = pan;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.attachments = attachments;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Integer id;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "DOB")
//	@Past
	private LocalDate  dob;
	@Column(name = "ADDRESS1")
	private String address1;
	@Column(name = "ADDRESS2")
	private String address2;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "PINCODE")
	private String pinCode;
	@Column(name = "PHONE")
	private String mobileNumber;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "AADHAR")
	private String aadhar;
	@Column(name = "PAN")
	private String pan;
	@Column(name = "USERNAME")
	private String userName;
	@Column(name = "PASSWORD")
	private String password;
	@Transient
	@Basic
	private String confirmPassword;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private Set<UploadFile>  attachments;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="accountholder")
	private Set<Account>  account;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ROLE")
	private UserRoles userRoles;
	@Column(name = "ENABLED")
	private boolean enabled;
	//getters and setters..................
	
	public String getFirstName() {
		return firstName;
	}
	
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public UserRoles getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(UserRoles userRoles) {
		this.userRoles = userRoles;
	}
	public Set<UploadFile> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<UploadFile> attachments) {
		this.attachments = attachments;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
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

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", address1="
				+ address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state + ", pinCode=" + pinCode
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", aadhar=" + aadhar + ", pan=" + pan
				+ ", userName=" + userName + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", attachments=" + attachments + "]";
	}
	public Set<Account> getAccount() {
		return account;
	}
	public void setAccount(Set<Account> account) {
		this.account = account;
	}
	
	//Overriden helpful methods for future references...........
	
}

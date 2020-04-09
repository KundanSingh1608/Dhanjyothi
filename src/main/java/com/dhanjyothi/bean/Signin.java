/**
 * 
 */
package com.dhanjyothi.bean;

import java.io.Serializable;

/**
 * @author GunjanKumar
 *
 */
public class Signin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7298716947587249376L;
    private String userName;
    private String password;
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
	@Override
	public String toString() {
		return "Signin [userName=" + userName + ", password=" + password + "]";
	}
    
    
}

/**
 * 
 */
package com.dhanjyothi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author KundanSingh
 *
 */
@Entity
@Table(name = "USER_ROLES",schema = "kundan")
public class UserRoles implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6627370589242545593L;
	/**
	 * @generated serial version uid
	 */
	//private static final long serialVersionUID = 2500513691195708570L;
	//private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ROLE_ID",nullable = false)
	private int id;
@Column(name = "ROLE_CODE",nullable = false)
	private String role_code;
@Column(name = "ROLE_DESC")
	private String role_desc;
@OneToMany(cascade = CascadeType.ALL,mappedBy = "userRoles")
	List<User> Users ;

	
	public List<User> getUsers() {
	return Users;
}
public void setUsers(List<User> users) {
	Users = users;
}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole_code() {
		return role_code;
	}
	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}
	public String getRole_desc() {
		return role_desc;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	@Override
	public String toString() {
		return "UserRoles [id=" + id + ", role_code=" + role_code + ", role_desc=" + role_desc + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((role_code == null) ? 0 : role_code.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoles other = (UserRoles) obj;
		if (id != other.id)
			return false;
		if (role_code == null) {
			if (other.role_code != null)
				return false;
		} else if (!role_code.equals(other.role_code))
			return false;
		return true;
	}
	
	
}

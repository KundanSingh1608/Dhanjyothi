package com.dhanjyothi.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "BENEFICIARY",catalog = "kundan")
public class Beneficiaries implements Serializable{

	/**
	 * generated version id
	 */
	private static final long serialVersionUID = -7954834380888129917L;
	@Id
	@Column(name = "BEN_ID",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ben_id;
	/* @Column(name = "OWNER_ID",nullable = false) */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ACCT_ID")
	private Account owner_id;
	@Column(name = "BEN_TYPE",nullable = false)
	private Character benType;
	@Column(name = "BEN_NAME ",nullable = false)
	@NotNull
	private String beneficiaryName;
	@Column(name = "BEN_NICK_NAME",nullable = false)
	@NotNull
	private String beneficiaryNickName;
	@Column(name = "BEN_ACCT_NUM",nullable = false)
	@NotNull
	private BigInteger benAccountNumber;
	@Column(name = "BEN_BANK")
	private String bankName;
	@Column(name = "BEN_BANK_IFSC")
	private String ifscCode;
	@Column(name = "USER_ID")
	private int userId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBen_id() {
		return ben_id;
	}
	public void setBen_id(int ben_id) {
		this.ben_id = ben_id;
	}
	public Account getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(Account owner_id) {
		this.owner_id = owner_id;
	}
	public Character getBenType() {
		return benType;
	}
	public void setBenType(Character benType) {
		this.benType = benType;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getBeneficiaryNickName() {
		return beneficiaryNickName;
	}
	public void setBeneficiaryNickName(String beneficiaryNickName) {
		this.beneficiaryNickName = beneficiaryNickName;
	}
	public BigInteger getBenAccountNumber() {
		return benAccountNumber;
	}
	public void setBenAccountNumber(BigInteger benAccountNumber) {
		this.benAccountNumber = benAccountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	@Override
	public String toString() {
		return "Beneficiaries [ben_id=" + ben_id + ", owner_id=" + owner_id + ", benType=" + benType
				+ ", beneficiaryName=" + beneficiaryName + ", beneficiaryNickName=" + beneficiaryNickName
				+ ", benAccountNumber=" + benAccountNumber + ", bankName=" + bankName + ", ifscCode=" + ifscCode + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((benAccountNumber == null) ? 0 : benAccountNumber.hashCode());
		result = prime * result + ben_id;
		result = prime * result + ((beneficiaryName == null) ? 0 : beneficiaryName.hashCode());
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
		Beneficiaries other = (Beneficiaries) obj;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (benAccountNumber == null) {
			if (other.benAccountNumber != null)
				return false;
		} else if (!benAccountNumber.equals(other.benAccountNumber))
			return false;
		if (ben_id != other.ben_id)
			return false;
		if (beneficiaryName == null) {
			if (other.beneficiaryName != null)
				return false;
		} else if (!beneficiaryName.equals(other.beneficiaryName))
			return false;
		return true;
	}
	
	
}

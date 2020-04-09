package com.dhanjyothi.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="ACCOUNT")
@NamedQueries({
	@NamedQuery(name = "HQL_ACCOUNT_BY_ID",query = "from Account acc join acc.accountholder user where user.id=:accountid and acc.accountType=:accountType")
})
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCT_ID", unique = false, nullable = false)
private Integer id;
//	@Column(name = "ACCT_HOLDER_ID", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "USER_ID")
private User accountholder;
	@Column(name = "ACCT_TYPE", nullable = false)
private char accountType;
	@Column(name = "INT_RATE", unique = false, nullable = false)
private double interestRate;
	@Column(name = "ACC_BALANCE",  nullable = false)
private long accountBalance;
	@Column(name = "DEPOSIT_TENURE", nullable = true)
private int accountTenure;
	@Column(name = "MATURITY_AMT ",  nullable = true)
private long maturityAmount;
	@Column(name = "ACCOUNT_CREATED_DATE ",  nullable = true,updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
private Date accountCreatedDate;
	@Column(name = "ACCOUNT_UPDATED_DATE ", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
private Date accountUpdatedDate;
	@Column(name = "MATURITY_DATE ", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
private Date maturityDate;
	@Column(name = "ACC_STATUS ", nullable = false)
private char accountStatus;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="owner_id")
	private Set<Beneficiaries>  beneficiary;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="DEBIT_ACCT")
	private Set<Transaction>  debtTransaction;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="CREDIT_ACCT")
	private Set<Transaction>  creditTransaction;
	
	
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Set<Transaction> getDebtTransaction() {
		return debtTransaction;
	}
	public void setDebtTransaction(Set<Transaction> debtTransaction) {
		this.debtTransaction = debtTransaction;
	}
	public Set<Transaction> getCreditTransaction() {
		return creditTransaction;
	}
	public void setCreditTransaction(Set<Transaction> creditTransaction) {
		this.creditTransaction = creditTransaction;
	}
	public Set<Beneficiaries> getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(Set<Beneficiaries> beneficiary) {
		this.beneficiary = beneficiary;
	}
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
public User getAccountholder() {
	return accountholder;
}
public void setAccountholder(User accountholder) {
	this.accountholder = accountholder;
}
public char getAccountType() {
	return accountType;
}
public void setAccountType(char accountType) {
	this.accountType = accountType;
}
public double getInterestRate() {
	return interestRate;
}
public void setInterestRate(double interestRate) {
	this.interestRate = interestRate;
}
public long getAccountBalance() {
	return accountBalance;
}
public void setAccountBalance(long accountBalance) {
	this.accountBalance = accountBalance;
}
public int getAccountTenure() {
	return accountTenure;
}
public void setAccountTenure(int accountTenure) {
	this.accountTenure = accountTenure;
}
public long getMaturityAmount() {
	return maturityAmount;
}
public void setMaturityAmount(long maturityAmount) {
	this.maturityAmount = maturityAmount;
}
public Date getAccountCreatedDate() {
	return accountCreatedDate;
}
public void setAccountCreatedDate(Date accountCreatedDate) {
	this.accountCreatedDate = accountCreatedDate;
}
public Date getAccountUpdatedDate() {
	return accountUpdatedDate;
}
public void setAccountUpdatedDate(Date accountUpdatedDate) {
	this.accountUpdatedDate = accountUpdatedDate;
}
public char getAccountStatus() {
	return accountStatus;
}
public void setAccountStatus(char accountStatus) {
	this.accountStatus = accountStatus;
}
@Override
public String toString() {
	return "Account [id=" + id + ", user=" + accountholder + ", accountType=" + accountType + ", interestRate="
			+ interestRate + ", accountBalance=" + accountBalance + ", accountTenure=" + accountTenure
			+ ", maturityAmount=" + maturityAmount + ", accountCreatedDate=" + accountCreatedDate
			+ ", accountUpdatedDate=" + accountUpdatedDate + ", accountStatus=" + accountStatus + "]";
}


}
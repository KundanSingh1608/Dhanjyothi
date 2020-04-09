package com.dhanjyothi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "TRANSACTION",catalog = "kundan")
public class Transaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1411304874104715100L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRN_ID", unique = true, nullable = false)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "DEBIT_ACCT")
    private Account DEBIT_ACCT;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "CREDIT_ACCT")
    private Account CREDIT_ACCT;
    @Column(name = "TRN_DESC",nullable = false)
    @NotNull(message = "Cannot be blank.This is required")
    private String transactionDesc;
    @Column(name = "TRN_AMT",nullable = false)
    @Min(0)
    private Long transactionAmount;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRN_DT_TIME",nullable = false)
    private Date transactionDate;
    @Transient
    private int benefeciaryId;
    @Column(name = "TRN_TYPE")
    private String transactionType;
    @Column(name = "USER_ID",nullable = false)
    private String userId;
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getBenefeciaryId() {
		return benefeciaryId;
	}
	public void setBenefeciaryId(int benefeciaryId) {
		this.benefeciaryId = benefeciaryId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Account getDEBIT_ACCT() {
		return DEBIT_ACCT;
	}
	public void setDEBIT_ACCT(Account dEBIT_ACCT) {
		DEBIT_ACCT = dEBIT_ACCT;
	}
	public Account getCREDIT_ACCT() {
		return CREDIT_ACCT;
	}
	public void setCREDIT_ACCT(Account cREDIT_ACCT) {
		CREDIT_ACCT = cREDIT_ACCT;
	}
	public String getTransactionDesc() {
		return transactionDesc;
	}
	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}
	public Long getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", DEBIT_ACCT=" + DEBIT_ACCT + ", CREDIT_ACCT=" + CREDIT_ACCT
				+ ", transactionDesc=" + transactionDesc + ", transactionAmount=" + transactionAmount
				+ ", transactionDate=" + transactionDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transactionAmount == null) ? 0 : transactionAmount.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((transactionDesc == null) ? 0 : transactionDesc.hashCode());
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
		Transaction other = (Transaction) obj;
		if (transactionAmount == null) {
			if (other.transactionAmount != null)
				return false;
		} else if (!transactionAmount.equals(other.transactionAmount))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionDesc == null) {
			if (other.transactionDesc != null)
				return false;
		} else if (!transactionDesc.equals(other.transactionDesc))
			return false;
		return true;
	}
    
    
}

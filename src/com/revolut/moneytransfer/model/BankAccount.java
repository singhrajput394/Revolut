package com.revolut.moneytransfer.model;

// Can use Builder design patter to create objects of this class. Not using to avoid dependency on Lombok
public class BankAccount {
	
	private String bankName;
	private String branchCode;
	private Integer bankAccountNumber;
	private float balanceAmount;
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	
	public String getBranchCode() {
		return branchCode;
	}
	
	public void setBankAccountNumber(Integer bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	
	public Integer getBankAccountNumber() {
		return bankAccountNumber;
	}
	
	public void setBalanceAmount(float balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	
	public float getBalanceAmount() {
		return balanceAmount;
	}

}

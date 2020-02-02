package com.revolut.moneytransfer.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MoneyTransferRequest {
	
	private String bankName;
	private Integer bankAccountNumber;
	
	public void setBankAccountNumber(Integer bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	
	public int getBankAccountNumber() {
		return bankAccountNumber;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getBankName() {
		return bankName;
	}
	
}

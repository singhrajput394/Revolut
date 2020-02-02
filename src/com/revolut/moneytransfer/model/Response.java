/** 
 * @author Abhishek Singh singh.rajput.394@gmail.com
 */

package com.revolut.moneytransfer.model;

import java.time.*;
import javax.xml.bind.annotation.XmlRootElement;

// Can also use Builder design patter for creating objects of this class. Not using to avoid dependency on Lombok

@XmlRootElement
public class Response {
	
	private String transactionId;
	private LocalDateTime timeStamp;
	private MoneyTransferRequest creditAccountDetails;
	private String message;
	private Integer responseCode;
	
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	
	public void setCreditAccountDetails(MoneyTransferRequest creditAccountDetails) {
		this.creditAccountDetails = creditAccountDetails;
	}
	
	public MoneyTransferRequest getCreditAccount() {
		return creditAccountDetails;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	
	public Integer getResposneCode() {
		return responseCode;
	}

}

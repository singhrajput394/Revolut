package com.revolut.moneytransfer.service;

import java.time.LocalDateTime;

import com.revolut.moneytransfer.model.MoneyTransferRequest;
import com.revolut.moneytransfer.model.Response;

public class ResponseBuilder {
	
	public static Response buildResponse(Integer responseCode,
			                      String message,
			                      MoneyTransferRequest creditBankAccount) {
									
		Response response = new Response();
		response.setResponseCode(responseCode);
		response.setMessage(message);
		response.setCreditAccountDetails(creditBankAccount);
		response.setTimeStamp(LocalDateTime.now());
		response.setTransactionId("XXXXXXXXXXXXXX"); // Some unique transaction ID generation algorithm
		
		return response;
	}

}

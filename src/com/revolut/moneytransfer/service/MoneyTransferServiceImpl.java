package com.revolut.moneytransfer.service;

import com.revolut.moneytransfer.dataStore.DataStore;
import com.revolut.moneytransfer.model.BankAccount;
import com.revolut.moneytransfer.model.MoneyTransferRequest;
import com.revolut.moneytransfer.model.Response;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/revolut")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class MoneyTransferServiceImpl implements MoneyTransferService {

	@Override
	@POST
	@Path("/moneytransfer")
	public Response transferMoneyBetweenAccounts(MoneyTransferRequest debitAccount, MoneyTransferRequest creditAccount, Integer transferAmount) {
		
		Integer debitBankAccountNumber = debitAccount.getBankAccountNumber();
		Integer creditBankAccountNumber = creditAccount.getBankAccountNumber();
		
		BankAccount debitBankAccount = DataStore.bankAccounts.get(debitBankAccountNumber);
		BankAccount creditBankAccount = DataStore.bankAccounts.get(creditBankAccountNumber);
		
		// For thread safe operations
		synchronized(this) {
			float currentDebitBalance = debitBankAccount.getBalanceAmount();
			float currentCreditBalance = creditBankAccount.getBalanceAmount();
			
			// Check if sufficient balance in debit account.
			if (transferAmount > currentDebitBalance) {
				 String message = "There is not enough balance in Debit Account.";
				 return ResponseBuilder.buildResponse(400 , message, creditAccount);
			}
			
			try {
				debitBankAccount.setBalanceAmount(currentDebitBalance - transferAmount);
				creditBankAccount.setBalanceAmount(currentCreditBalance + transferAmount);
				String message = "Successfully transferred amount to the beneficiary account.";
				return ResponseBuilder.buildResponse(200 , message, creditAccount);
				
			} catch(Exception ex) {
				// Revert back to previous balance if any of the above operation fails.
				debitBankAccount.setBalanceAmount(currentDebitBalance);
				creditBankAccount.setBalanceAmount(currentCreditBalance);
				return ResponseBuilder.buildResponse(400 , ex.getMessage(), creditAccount);
			}
		}
		
	}

}

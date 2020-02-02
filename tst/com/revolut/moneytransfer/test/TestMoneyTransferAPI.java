package com.revolut.moneytransfer.test;

import com.revolut.moneytransfer.dataStore.DataStore;
import com.revolut.moneytransfer.model.BankAccount;
import com.revolut.moneytransfer.model.MoneyTransferRequest;
import com.revolut.moneytransfer.model.Response;
import com.revolut.moneytransfer.service.MoneyTransferService;
import com.revolut.moneytransfer.service.MoneyTransferServiceImpl;

public class TestMoneyTransferAPI {

	public static void main(String[] args) {
		/**
		 * Build data store first. Create two accounts and add them to data store.
		 */
		
		// Can use builder design patter here
		BankAccount debitBankAccount = new BankAccount();
		debitBankAccount.setBankName("Wellsfargo");
		debitBankAccount.setBankAccountNumber(12345);
		debitBankAccount.setBalanceAmount((float)100.10);
		debitBankAccount.setBranchCode("US-101");
		
		BankAccount creditBankAccount = new BankAccount();
		creditBankAccount.setBankName("JPMorgan");
		creditBankAccount.setBankAccountNumber(67891);
		creditBankAccount.setBalanceAmount((float)200.10);
		creditBankAccount.setBranchCode("US-201");
		
		System.out.println("Debit account current balance: " + debitBankAccount.getBalanceAmount());
		System.out.println("Credit account current balance: " + creditBankAccount.getBalanceAmount());
		
		// Add debit and credit bank accounts to in memory data store.
		DataStore.bankAccounts.put(12345, debitBankAccount);
		DataStore.bankAccounts.put(67891, creditBankAccount);
		
		/**
		 * Build request params for the API
		 */
		MoneyTransferRequest debitAccountRequest = new MoneyTransferRequest();
		debitAccountRequest.setBankName(debitBankAccount.getBankName());
		debitAccountRequest.setBankAccountNumber(debitBankAccount.getBankAccountNumber());
		
		MoneyTransferRequest creditAccountRequest = new MoneyTransferRequest();
		creditAccountRequest.setBankName(creditBankAccount.getBankName());
		creditAccountRequest.setBankAccountNumber(creditBankAccount.getBankAccountNumber());
		
		Integer amountToTransfer = new Integer(50);
		System.out.println("Transferring amount: " + amountToTransfer);
		System.out.println("---------------------------------");
		
		/**
		 *  Call API for transferring money from debit to credit account.
		 */
		
		MoneyTransferService service = new MoneyTransferServiceImpl();
		Response response = service.transferMoneyBetweenAccounts(debitAccountRequest, creditAccountRequest, amountToTransfer);
		
		System.out.println(response.getResposneCode());
		System.out.println(response.getMessage());
		System.out.println("Transaction ID: " + response.getTransactionId());
		System.out.println("Credit account number: " + response.getCreditAccount().getBankAccountNumber());
		System.out.println("---------------------------------");
		System.out.println("Debit account current balance: " + debitBankAccount.getBalanceAmount());
		System.out.println("Credit account current balance: " + creditBankAccount.getBalanceAmount());
	}
}

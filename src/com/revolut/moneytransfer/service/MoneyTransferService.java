package com.revolut.moneytransfer.service;

import com.revolut.moneytransfer.model.MoneyTransferRequest;
import com.revolut.moneytransfer.model.Response;

public interface MoneyTransferService {
	
	public Response transferMoneyBetweenAccounts(MoneyTransferRequest debitAccount, MoneyTransferRequest creditAccount,
			Integer transferAmount);

}

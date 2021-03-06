package com.cg.pp.dao;

import java.util.List;

import com.cg.pp.entities.Transactions;
import com.cg.pp.entities.Wallet;
import com.cg.pp.exceptions.WalletExceptions;

public interface WalletDao {
	Wallet create(Wallet wallet);

	double showBalance(String mobileno) throws WalletExceptions;

	double deposit(String mobileno, double amount) throws WalletExceptions;

	double withdraw(String mobileno, double amount) throws WalletExceptions;

	Wallet transfer(String mob_from, String mob_to, double amount) throws WalletExceptions;

	List<Transactions> printTransactions(String mobileno) throws WalletExceptions;

	boolean exists(String mobileno) throws WalletExceptions;

}

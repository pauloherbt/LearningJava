package trycatch;

import trycatch.exceptions.withdrawException;

public class Account {
	private String holder;
	private int number;
	private double balance;
	private double withdrawLimit;
	
	public Account(String holder, int number, double balance, double withdrawLimit) {
		this.holder = holder;
		this.number = number;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double amount ) {
		this.balance+=amount;
	}
	private void withdrawValidate(double amount) throws withdrawException{
		if(amount>withdrawLimit) {
			throw new withdrawException("Error:insufficient withdraw limit ");
		}
		if(amount>balance) {
			throw new withdrawException("Error:Insufficient balance");
		}
	}
	public void withdraw(double amount) throws withdrawException {
		withdrawValidate(amount);
		this.balance-=amount;
	}

	public double getBalance() {
		return balance;
	}
	
	
}

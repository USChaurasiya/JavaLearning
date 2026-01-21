package com.us.java.learning.java8.concurrency.threadSafety;

/**
 * 
 */
public class BankAccount {
	
	private int balance = 50;
	
	public int getBalance() {
		return balance;
	}
	
	public void withdraw(int balance) {
		this.balance -= balance;
	}

}

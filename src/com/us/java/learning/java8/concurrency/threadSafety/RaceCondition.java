package com.us.java.learning.java8.concurrency.threadSafety;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 */
public class RaceCondition implements Runnable {

	// Another way to Avoid Race Condition is Using Lock
	private static Lock lock = new ReentrantLock();

	private BankAccount account = new BankAccount();

	public static void main(String[] args) {
		Runnable runnable = new RaceCondition(); // Only one Instance
		Thread john = new Thread(runnable); // Both Thread share the same Instance
		Thread mary = new Thread(runnable);

		john.setName("John");
		mary.setName("Mary");

		john.start();
		mary.start();
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			makeWithdrawalWithLock(10);
			if (account.getBalance() < 0)
				System.out.println("Account is Overdrawn !!");
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

	// Fix the Race Condition : Make the makeWithdrawal method as synchronized
	private synchronized void makeWithdrawal(int antToWithdraw) {
		// Race Condition
		// private void makeWithdrawal(int antToWithdraw) {
		if (account.getBalance() >= antToWithdraw) {
			System.out.println(Thread.currentThread().getName() + " Balance Before : " + account.getBalance());

			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			account.withdraw(antToWithdraw);
			System.out.println(Thread.currentThread().getName() + " Balance After : " + account.getBalance());

		} else {
			System.out.println(
					Thread.currentThread().getName() + " is Unable to Withdraw as Balance is: " + account.getBalance());

		}

	}

	// Another way of making thread safe using Lock interface.
	private void makeWithdrawalWithLock(int antToWithdraw) {

		try {
			lock.lock();
			if (account.getBalance() >= antToWithdraw) {
				System.out.println(Thread.currentThread().getName() + " Balance Before : " + account.getBalance());

				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
				account.withdraw(antToWithdraw);
				System.out.println(Thread.currentThread().getName() + " Balance After : " + account.getBalance());

			} else {
				System.out.println(Thread.currentThread().getName() + " is Unable to Withdraw as Balance is: "
						+ account.getBalance());

			}
		} finally {
			lock.unlock();
		}

	}

}

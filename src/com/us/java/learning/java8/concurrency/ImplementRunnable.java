package com.us.java.learning.java8.concurrency;

/**
 * Creating Thread by Implementing the Runnable Interface
 * 
 */
public class ImplementRunnable implements Runnable {

	@Override
	public void run() {

		System.out.println("Run() : " + Thread.currentThread().getName());

	}

	public static void main(String[] args) {
		new Thread(new ImplementRunnable()).start();
		System.out.println("main() : " + Thread.currentThread().getName());
	}

}

package com.us.java.learning.java8.concurrency;

/**
 * Creating Thread by implementing Runnable interface using Lambda Expression
 * 
 */
public class UsingLambdaAsRunnable {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> System.out.println("Run() : " + Thread.currentThread().getName()));
		thread.start();
		System.out.println("main() : " + Thread.currentThread().getName());
	}

}

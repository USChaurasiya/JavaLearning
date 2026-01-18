package com.us.java.learning.java8.concurrency;

/**
 * Creating Thread by implementing Runnable interface using Lambda Expression
 * 
 */
public class UsingLambdaAsRunnable {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> System.out.println("Run() : " + Thread.currentThread().getName()));
		
		//thread.start();
		thread.run();  // If we call the run() method directly then no new thread will get created, it will run in the same main thread.
		System.out.println("main() : " + Thread.currentThread().getName());
	}

}

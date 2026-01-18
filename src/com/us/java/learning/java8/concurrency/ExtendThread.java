package com.us.java.learning.java8.concurrency;

/**
 * Extend Thread Class
 * 
 * Creating Thread by Extending the Thread Class
 * 
 */
public class ExtendThread extends Thread
{

	public void run() {
		System.out.println("Run() : "+getName());
	}
	
	public static void main(String[] args) {
		
		new ExtendThread().start();
		System.out.println("main() : "+Thread.currentThread().getName());
	}
}

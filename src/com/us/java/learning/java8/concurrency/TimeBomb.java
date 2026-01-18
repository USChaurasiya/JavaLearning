package com.us.java.learning.java8.concurrency;

/**
 * 
 */
public class TimeBomb {

	public static void main(String[] args) {
		Thread timer = new Thread(new CountDown());
		System.out.println("Starting 10 Second Count down ... ");
		timer.start();

		try {
			timer.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("Boom!!!!");
	}

}

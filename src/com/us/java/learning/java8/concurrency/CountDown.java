package com.us.java.learning.java8.concurrency;

/**
 * Writing a Count down which will count from 9 to 0 with some delay.
 * 
 */
public class CountDown implements Runnable {

	String[] timerString = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

	@Override
	public void run() {
		for (int i = 9; i >= 0; i--) {
			System.out.println(timerString[i]);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

}

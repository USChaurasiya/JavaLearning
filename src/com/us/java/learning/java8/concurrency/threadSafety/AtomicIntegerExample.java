package com.us.java.learning.java8.concurrency.threadSafety;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		for (int i = 0; i <= 10; i++) {
			executorService.submit(() -> System.out.print(atomicInteger.incrementAndGet() + " "));
		}
		executorService.shutdown();
	}

}

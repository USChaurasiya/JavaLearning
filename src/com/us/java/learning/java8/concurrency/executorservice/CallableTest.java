package com.us.java.learning.java8.concurrency.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableTest {

	public static void main(String[] args) {

		// Create an ExecutorService with a fixed thread pool consisting of one Thread.
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Future<Integer> future = executorService.submit(() -> 3 + 5);

		try {
			System.out.println("The Answer is : " + future.get(500, TimeUnit.MILLISECONDS));
		} catch (InterruptedException | ExecutionException | TimeoutException e) {

			e.printStackTrace();
		}

		executorService.shutdown();

	}
}

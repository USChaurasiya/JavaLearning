package com.us.java.learning.java8.concurrency.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmittingTaskCollections {

	// 1: Single Thread Executors will accept the task sequentially in the order they are submitted.
	// private static ExecutorService executorService = Executors.newSingleThreadExecutor();

	// 2: With 4 thread to share the work, there is no guarantee which letter will appear First.
	private static ExecutorService executorService = Executors.newFixedThreadPool(4);
	private static List<Callable<String>> callables = new ArrayList<>();

	public static void main(String[] args) {
		callables.add(() -> "A");
		callables.add(() -> "B");
		callables.add(() -> "C");
		callables.add(() -> "D");
		callables.add(() -> "E");

		// invokeAny();
		invokeAll();
	}

	public static void invokeAny() {

		String result;
		try {

			// Single thread Executor will always execute the first Task Submitted.
			result = executorService.invokeAny(callables);
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}

		System.out.println("Always At the Ends!!");
	}

	private static void invokeAll() {
		
		// Submitting a collection of Tasks.
		// Executes Synchronously and returns when all the tasks are completed. Order is maintained. 

		try {
			List<Future<String>> list = executorService.invokeAll(callables);
			for (Future<String> future : list) {
				System.out.println(future.get());
			}
		} catch (InterruptedException | ExecutionException e) {

			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
		System.out.println("Always at the Ends!!");
	}

}

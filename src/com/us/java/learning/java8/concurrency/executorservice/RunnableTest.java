package com.us.java.learning.java8.concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTest {
	public static void main(String[] args) {
		//Create an ExecutorService with a fixed thread pool consisting of one Thread.
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		//Execute the Runnable task Asynchronously
		executorService.execute(()-> System.out.println("Runnable Example"));
		
		
		// Shutdown the executor service otherwise this application will never Terminate.
		// Existing task will be allowed to complete but no new task accepted.
		executorService.shutdown();
	}

}

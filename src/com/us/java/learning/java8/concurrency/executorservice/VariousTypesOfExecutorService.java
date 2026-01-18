package com.us.java.learning.java8.concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Various way of Creating the ExecutorService. 
 * 1: CachedThreadPool 
 * 2: FixedThreadPool 
 * 3: SingleThreadExecutor
 */
public class VariousTypesOfExecutorService {

	public static void main(String[] args) {

		// 1: CachedThreadPool
		ExecutorService executorService = Executors.newCachedThreadPool();

		// 2: FixedThreadPool
		int couCount = Runtime.getRuntime().availableProcessors();
		ExecutorService executorService2 = Executors.newFixedThreadPool(couCount);

		// 3: SingleThreadExecutor
		ExecutorService executorService3 = Executors.newSingleThreadExecutor();
	}

}

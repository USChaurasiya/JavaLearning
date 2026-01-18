package com.us.java.learning.java8.concurrency.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutors {
	
	private static ScheduledExecutorService scExecutorService = Executors.newScheduledThreadPool(10);
	
	public static void main(String[] args) {
		//schedule();
		
		//scheduleWithFixedDelay();
		
		scheduleAtFixedRate();
	}

	private static void scheduleAtFixedRate() {
		System.out.println("Start!!!");
		
		final long INITIAL_DELAY = 2000, WAIT_PERIOD_BEFORE_STARTING_NEXT_TASK = 300;
		scExecutorService.scheduleAtFixedRate(()->System.out.println("Thread ID : "+Thread.currentThread().getId()), 
				INITIAL_DELAY, WAIT_PERIOD_BEFORE_STARTING_NEXT_TASK, TimeUnit.MILLISECONDS);
		
	}

	private static void scheduleWithFixedDelay() {
		System.out.println("Start!!!");
		
		// 300ms is the time to wait from when the previous task finishes to starting the next task.
		final long INITIAL_DELAY = 2000, WAIT_PERIOD_AFTER_PREVIOUS_TASK_FINISHED = 300;
		scExecutorService.scheduleWithFixedDelay(()->System.out.println("Thread ID : "+Thread.currentThread().getId()), 
				INITIAL_DELAY,WAIT_PERIOD_AFTER_PREVIOUS_TASK_FINISHED, TimeUnit.MILLISECONDS);
		
	}

	private static void schedule() {
		System.out.println("Start!!!");
		Future<String> future = scExecutorService.schedule(()->"A", 2, TimeUnit.SECONDS);
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			
			e.printStackTrace();
		}finally {
			scExecutorService.shutdown();
		}
		System.out.println("Always At the End!!!");
	}

}

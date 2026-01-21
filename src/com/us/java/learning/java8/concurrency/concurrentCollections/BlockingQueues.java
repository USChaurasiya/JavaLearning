package com.us.java.learning.java8.concurrency.concurrentCollections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueues {
	
	public static void main(String[] args) {
		
		BlockingQueue<String> queue = new LinkedBlockingQueue<>();
		// regular Queue Methods
		queue.offer("Red");
		queue.offer("Green");
		queue.offer("Blue");
		
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue);
		
		// Special BlockingQueue Methods
		try {
			
			// Block if queue Full
			queue.offer("White", 100, TimeUnit.MILLISECONDS);
			
			// Block if queue is Empty
			queue.poll(200, TimeUnit.MILLISECONDS);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(queue);
	}

}

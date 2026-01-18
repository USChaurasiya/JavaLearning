package com.us.java.learning.java8.concurrency.threadSafety;

/**
 * 1: public synchronized static void addToCounter()
 * 
 * 2: public static void addToCounter(){
 * synchronized(FixRaceWithSynchronized.class){
 * 
 * 3: synchronized(lock){
 * 
 * 4: synchronize on 'this'
 * 
 */
public class FixRaceWithSynchronized {

	private static Object lock = new Object();
	private static int count = 0;

	// 1: By adding synchronized in method signature.
	public synchronized static void addToCounter() {

		int c = count;
		System.out.println("Before : " + count + " Thread Id : " + Thread.currentThread().getId());

		count = c + 1;
		System.out.println("After : " + count + " Thread Id : " + Thread.currentThread().getId());
	}

	// 2: synchronized()
	public static void addToCounter1() {
		synchronized (FixRaceWithSynchronized.class) {
			int c = count;
			System.out.println("Before : " + count + " Thread Id : " + Thread.currentThread().getId());

			count = c + 1;
			System.out.println("After : " + count + " Thread Id : " + Thread.currentThread().getId());
		}

	}

	// 3: Creating a Lock object
	public static void addToCounter2() {

		synchronized (lock) {
			int c = count;
			System.out.println("Before : " + count + " Thread Id : " + Thread.currentThread().getId());

			count = c + 1;
			System.out.println("After : " + count + " Thread Id : " + Thread.currentThread().getId());
		}

	}

	// 4: Make the addToCounter() as instance method
	// synchronized(this) inside the method
	// create an instance of the overall class FixRaceWithSynchronized in main()
	// ensure that all the threads share the same instance
	public void addToCounter3() {

		synchronized (this) {
			int c = count;
			System.out.println("Before : " + count + " Thread Id : " + Thread.currentThread().getId());

			count = c + 1;
			System.out.println("After : " + count + " Thread Id : " + Thread.currentThread().getId());
		}

	}

	public static void main(String[] args) {

		FixRaceWithSynchronized fixRaceWithSynchronized = new FixRaceWithSynchronized();
		for (int i = 1; i <= 10; i++) {
			// new Thread(() -> addToCounter2()).start();
			new Thread(() -> fixRaceWithSynchronized.addToCounter3()).start();
		}
	}

}

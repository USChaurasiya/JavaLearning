package com.us.java.learning.java8.collection;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueuesExample {

	public static void main(String[] args) {

		linkedListQueue();

		arrayDeque();
		
		priorityQueueNaturalOrder();
		
		priorityQueueDifferentOrder();
	}

	/**
	 * Ordering Specified by a comparator at construction time.
	 * 
	 */
	public static void priorityQueueDifferentOrder() {
		
		// Comparator.comparing(Function)
		// 1: Order by Title of the Book
		Comparator<Book> comparatorTitle = Comparator.comparing(book -> book.getTitle());
		Queue<Book> bookByTitle = new PriorityQueue<>(comparatorTitle);
		bookByTitle.add(new Book("Java", 100.0));
		bookByTitle.add(new Book("Pyhton", 50.0));
		bookByTitle.add(new Book("C++", 200.0));
		
		System.out.println("Order by Title : ");
		Iterator bookIterator = bookByTitle.iterator();
		while(bookIterator.hasNext()) {
			
			Book book = bookByTitle.poll();
			System.out.println(book);
		}
		
		// 1: Order by Price of the Book
		Comparator<Book> comparatorPrice = Comparator.comparing(Book::getPrice);
		Queue<Book> bookByPrice = new PriorityQueue<>(comparatorPrice);
		bookByPrice.add(new Book("Java", 100.0));
		bookByPrice.add(new Book("Pyhton", 50.0));
		bookByPrice.add(new Book("C++", 200.0));

		System.out.println("Order by Price : ");
		Iterator bookPriceIterator = bookByPrice.iterator();
		while (bookPriceIterator.hasNext()) {

			Book book = bookByPrice.poll();
			System.out.println(book);
		}
			
	}

	/**
	 * 
	 */
	public static void priorityQueueNaturalOrder() {
		Queue<String> names = new PriorityQueue<>();
		names.add("U");
		names.add("M");
		names.add("A");
		Iterator nameIterator = names.iterator();
		while(nameIterator.hasNext())
			System.out.println(names.poll()+" ");
		
		Queue<Integer> numbers = new PriorityQueue<>();
		numbers.add(10);
		numbers.add(2);
		numbers.add(31);
		Iterator numIterator = numbers.iterator();
		while(numIterator.hasNext())
			System.out.println(numbers.poll()+" ");
	}

	/**
	 * Deque : Doubly ended Queue, supports element insert/removal at both ends
	 * ArrayDeques : resizeable array implementation of Deque interface
	 * 
	 * removeFirst(), removeLast(), getFirst(), getLast() all throws exception if
	 * the queue is both capacity-constraint and full. Other methods PeekFirst(),
	 * peekLast(), offerFirst(), offerLast(), pollFisrt(), pollLast() rather than
	 * throw an exception in the same situation, they returns Null/False.
	 * 
	 */
	public static void arrayDeque() {
		Deque<Integer> numbers = new ArrayDeque<>();
		// Add at the front
		numbers.add(1);
		numbers.addFirst(2);
		numbers.offerFirst(3);
		System.out.println("Head : " + numbers.getFirst() + ". Head : " + numbers.peekFirst());

		// Add at the end
		numbers.addLast(4);
		numbers.offerLast(5);

		// Remove from both End
		numbers.removeFirst();
		numbers.pollFirst();
		numbers.removeLast();
		numbers.pollLast();

		System.out.println(numbers);
	}

	/**
	 * add() insert into queue (throws exception if no space exists) offer() insert
	 * into queue (returns false if no space exists) element() retrieves but does
	 * not remove the head of the queue ( throws exception if queue is empty) peek()
	 * retrieves but does not remove head (returns null if queue is Empty) remove()
	 * retrieves and remove head ( throws exception if queue is empty poll()
	 * retrieves and remove head (returns null if queue is Empty)
	 */
	public static void linkedListQueue() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		queue.offer(2);
		queue.add(3);
		queue.offer(4);

		System.out.println(queue.element());
		System.out.println(queue.peek());
		System.out.println(queue);

		System.out.println(queue.remove());
		System.out.println(queue.poll());
		System.out.println(queue);
	}
	
	

}

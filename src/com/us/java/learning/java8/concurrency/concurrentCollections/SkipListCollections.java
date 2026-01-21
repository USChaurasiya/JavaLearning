package com.us.java.learning.java8.concurrency.concurrentCollections;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * 
 */
public class SkipListCollections {
	
	public static void main(String[] args) {
		Set<String> countries = new ConcurrentSkipListSet<>();  // Concurrent TreeSet
		countries.add("India");
		countries.add("Australia");
		countries.add("Canada");
		
		System.out.println("Countries using ConcurrentSkipListSet : ");
		// Natural Order for String
		countries.stream().forEach(System.out::println);
		
		Map<String , Integer> map = new ConcurrentSkipListMap<>(); // Concurrent TreeMap
		map.put("Jack", 12);
		map.put("Zack", 30);
		map.put("Robin", 14);
		
		System.out.println("Map using ConcurrentSkipListSet : ");
		// Ordered by Key
		map.forEach((k, v)-> System.out.println("Key : "+ k + "  and Value : "+v));
		
	}

}

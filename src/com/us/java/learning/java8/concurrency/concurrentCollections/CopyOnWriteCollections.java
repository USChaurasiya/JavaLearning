package com.us.java.learning.java8.concurrency.concurrentCollections;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteCollections {
	
	public static void main(String[] args) {
		List<String> names = new CopyOnWriteArrayList<>();
		names.add("Aptom");
		names.add("Brian");
		names.add("Carol");
		
		for(String name : names) {
			System.out.println(name);
			names.add(name);
		}
		
		System.out.println("List Elemets : "+names);
		System.out.println("-----------------------");
		
		
		Set<String> uniqueNames = new CopyOnWriteArraySet<>();
		uniqueNames.add("Aptom");
		uniqueNames.add("Brian");
		uniqueNames.add("Carol");
		
		for(String name : uniqueNames) {
			System.out.println(name);
			uniqueNames.add(name);
		}
		
		System.out.println("Set Elemets : "+uniqueNames);
		System.out.println("-----------------------");
	}

}

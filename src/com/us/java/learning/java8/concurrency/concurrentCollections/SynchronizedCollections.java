package com.us.java.learning.java8.concurrency.concurrentCollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class SynchronizedCollections {
	
	public static void main(String[] args) {
		
		Map<String , String> capitalCities  = new HashMap<>(); // It will give Exception
		//Map<String , String> capitalCities  = new ConcurrentHashMap<>(); // It will fix
		capitalCities.put("Oslo", "Norway");
		capitalCities.put("Delhi", "India");
		
		Map<String , String> synchronizedcapitalCities  = Collections.synchronizedMap(capitalCities); // Creating Sync Map
		/*
		 * for(String key : capitalCities.keySet()) { System.out.println(key +
		 * " is the Capital of "+capitalCities.get(key)); capitalCities.remove(key); }
		 */
		
		for(String key : synchronizedcapitalCities.keySet()) {
			System.out.println(key + " is the Capital of "+synchronizedcapitalCities.get(key));
			//synchronizedcapitalCities.remove(key);
		}
	}
	

}

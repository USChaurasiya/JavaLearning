package com.us.java.learning.java8.Stream;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PremitiveStream {

	public static void main(String[] args) {
		
		// 1: IntStream
		int[] intArray = { 1, 2, 3, 4};
		IntStream intStream = Arrays.stream(intArray);
		System.out.println("No of the elements : "+intStream.count());
		
		IntStream intS = IntStream.of(1, 2, 3, 4);
		System.out.println("No of elemets : "+intS.count());
		
		// 2: DoubleStream
		double[] doubleArray = {1.1, 2.2, 3.3};
		DoubleStream doubleStream = Arrays.stream(doubleArray);
		System.out.println("No of elements in Double Stream: "+doubleStream.count());
		
		DoubleStream doubleS = DoubleStream.of(1.1, 2.2, 3.3);
		System.out.println(" No of Elemets in DoubleStream : "+doubleS.count());
		
		
		// 3: LongStream
		long[] longArray = {1L, 2L, 3L, 4L};
		LongStream longStream = Arrays.stream(longArray);
		System.out.println("No of elements :　"+longStream.count());
		
		LongStream longS = LongStream.of(1L, 2L, 3L, 4L);
		System.out.println("No of elements :　"+longS.count());
		
		// Common Primitive Stream Methods
		// 1: max()
		OptionalInt max = IntStream.of(1, 20, 30, 50).max();
		max.ifPresent(System.out::println);
		
		// 2: min()
		OptionalDouble min = DoubleStream.of(10.0, 20.0, 30.0, 40.0).min();
		min.ifPresent(System.out::println);
		
		// 3: average()
		OptionalDouble average = LongStream.of(10L, 40L, 60L, 90L).average();
		System.out.println(average.orElseGet(()->Math.random()));
	}
}

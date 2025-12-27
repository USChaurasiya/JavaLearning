package com.us.java.learning.java8.Stream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveFunctionalInterface {

	public static void main(String[] args) {

		// Converting Stream of String to another Stream of String
		Stream.of("ash", "beech", "sycamore").map(tree -> tree.toUpperCase()).forEach(System.out::println);

		// Converting Stream of String to Stream of Double
		DoubleStream dbStream = Stream.of("ash", "beech", "sycamore").mapToDouble(x -> x.length());
		dbStream.forEach(System.out::println);

		// Converting Stream of String to Stream of Integer
		IntStream intStream = Stream.of("ash", "beech", "sycamore").mapToInt(x -> x.length());
		intStream.forEach(System.out::println);

		// Converting Stream of String to Stream of Long
		LongStream longStream = Stream.of("ash", "beech", "sycamore").mapToLong(x -> x.length());
		longStream.forEach(System.out::println);

		// Converting Stream on Integer to stream of String
		Stream<String> streamAges = IntStream.of(1, 2, 3).mapToObj(n -> "Number: " + n);
		streamAges.forEach(System.out::println);

		// Converting IntStream to DoubleStream
		DoubleStream doubleStream = IntStream.of(1, 2, 4, 3).mapToDouble(n -> (double) n);
		doubleStream.forEach(System.out::println);

		// Converting IntStream to LongStream
		IntStream.of(1, 2, 3, 4).mapToLong(n -> (long) n).forEach(System.out::println);

	}

}

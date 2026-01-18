package com.us.java.learning.java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * Parallel Stream can process elements in a stream concurrently i.e At the same time.
 */
public class JavaParallelStream {

	public static void main(String[] args) {

		Stream<String> animalStream = List.of("Sheep", "Pigs", "Horses").parallelStream();
		Stream<String> animalStream1 = Stream.of("Sheep", "Pigs", "Horses").parallel();

		// Sequential Stream
		int sum = Stream.of(10, 20, 30, 40, 50, 60).mapToInt(n -> n.intValue()).sum();
		System.out.println("Sum of the given numbers : " + sum);

		// Parallel Stream
		int addition = Stream.of(10, 20, 30, 40, 50, 60).parallel().mapToInt(Integer::intValue).sum();
		System.out.println("Addition of these numbers : " + addition);

		// If order is important then sequential Stream is better choice then Parallel Stream
		sequentialstream();
		System.out.println();
		parallelstream();

	}

	public static void sequentialstream() {
		Arrays.asList("a", "b", "c").stream().forEach(System.out::print);
	}

	public static void parallelstream() {
		Arrays.asList("a", "b", "c").stream().parallel().forEach(System.out::print);
	}
}

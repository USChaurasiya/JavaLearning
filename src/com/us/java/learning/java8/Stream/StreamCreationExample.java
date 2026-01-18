package com.us.java.learning.java8.Stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreationExample {

	public static void main(String[] args) {

		// 1: Creating Stream from Array

		Double[] numbers = { 1.1, 2.2, 3.3 };
		Stream<Double> doubleStream = Arrays.stream(numbers);
		System.out.println("Number of Elements :" + doubleStream.count());

		// 2: Creating Stream from Collection
		List<String> names = Arrays.asList("David", "John", "Maddy");
		Stream<String> nameStream = names.stream();
		nameStream.forEach(System.out::println);

		// 3: Creating Stream with Stream.of()
		Stream<Integer> numberStream = Stream.of(1, 2, 3, 4, 5);
		numberStream.forEach(System.out::println);

		Stream<String> stringStream = Stream.of("a", "b", "c", "d");
		stringStream.forEach(System.out::println);

		// 4: Creating a Stream from a File
		List<Country> countries = loadFileContent("CountryCapital.txt");
		countries.forEach(System.out::println);
		
		
		// Infinite Stream
		Stream<Integer> infStream = Stream.generate(()->{
			return (int)(Math.random()*10);
		});
		
		// It will Keep printing Random Number until Process is not Stopped
		//infStream.forEach(System.out::println);
		
		// Infinite Stream can be turned into Finite Stream with operations such as limit(long)
		Stream.iterate(2,n -> n+2).limit(10).forEach(System.out::println);

	}

	public static List<Country> loadFileContent(String fileName) {

		List<Country> countries = new ArrayList<>();
		try {
			Stream<String> fileContentStream = Files.lines(Paths.get(fileName));
			fileContentStream.forEach(lines -> {
				String[] texts = lines.split("-");
				countries.add(new Country(texts[0], texts[1]));
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return countries;
	}
}

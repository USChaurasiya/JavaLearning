package com.us.java.learning.java8.Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperator {

	public static void main(String[] args) {

		// 1: sorted()
		Person john = new Person("John", 25);
		Person marry = new Person("Marry", 30);

		Stream.of(john, marry).sorted(Comparator.comparing(p -> p.getName())).forEach(System.out::println);

		// 2: map()
		Stream.of("book", "pen", "ruler").map(s -> s.length()).forEach(System.out::println);

		// 3: flatMap()
		List<String> list1 = Arrays.asList("John", "Sean");
		List<String> list2 = Arrays.asList("Mike", "Peter");
		Stream<List<String>> streamList = Stream.of(list1, list2);

		streamList.flatMap(list -> list.stream()).forEach(System.out::println);

		// 4: filter()
		Stream.of("book", "pen", "ruler").filter(s -> s.length() > 3).forEach(System.out::println);

		// 5: distinct()
		Stream.of("eagle", "eagle", "Eagle").peek(s -> System.out.println("Before Distinct :" + s)).distinct()
				.forEach(s -> System.out.println("After Distinct :" + s));
		
		// 6: limit()
		Stream.of(11, 22, 33, 44, 55, 66, 77)
		.filter(n -> n > 40)
		.limit(2)
		.forEach(System.out::println);
	}

}

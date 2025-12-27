package com.us.java.learning.java8.Stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperator {

	public static void main(String[] args) {

		// 1: collect(Collector)
		String s = Stream.of("Cake", "biscuits", "apple tart").collect(Collectors.joining(", "));
		System.out.println(s);

		Double lengthAvg = Stream.of("Cake", "biscuits", "apple tart")
				.collect(Collectors.averagingInt(x -> x.length()));
		System.out.println("Average length of the string: " + lengthAvg);

		// 2: Collectors.toMap()
		Map<String, Integer> map = Stream.of("Cake", "biscuits", "apple tart")
				.collect(Collectors.toMap(k -> k, k -> k.length()));
		System.out.println(map);

		// Here two string have the same length and as our length is the key and we can't duplicate the key. this lead to an exception
		// To get around this we can supply a merge function where we append the colliding key values together.
		Map<Integer, String> map1 = Stream.of("Cake", "biscuits", "tart")
				.collect(Collectors.toMap(k -> k.length(), k -> k, (s1, s2) -> s1 + "," + s2));
		System.out.println(map1);

		// 3: Collectors.toMap()
		// The map returned HashMap but this is not guaranteed. What is we wanted a TreeMap implementation so our key would be sorted.
		// The Last Argument caters for this.
		TreeMap<String, Integer> map2 = Stream.of("cake", "biscuits", "apple tart", "cake").collect(
				Collectors.toMap(key -> key, key -> key.length(), (len1, len2) -> len1 + len2, () -> new TreeMap<>()));

		System.out.println(map2);

		// 4: Collectors.groupingBy()

		// GroupingBy tells Collect() to group all of the elements into a Map.
		Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
		Map<Integer, List<String>> nameMap = names.collect(Collectors.groupingBy(String::length));
		System.out.println(nameMap);

		// If you want Set instead of List
		Stream<String> names1 = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
		Map<Integer, Set<String>> nameSetMap = names1
				.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
		System.out.println(nameSetMap);

		// If you wanted to ensure we get back a TreeMap but leave the values a List.
		Stream<String> names2 = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
		TreeMap<Integer, List<String>> nameTreeMap = names2
				.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
		System.out.println(nameTreeMap);

		// 5: Collectors.partitioningBy()
		// Partitioning is a special case of grouping where there are only two possible groups - true and false.
		// The key will be boolean true and false
		Stream<String> nameList = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
		Map<Boolean, List<String>> partitionMap = nameList
				.collect(Collectors.partitioningBy(key -> key.startsWith("T")));
		System.out.println(partitionMap);

	}

}

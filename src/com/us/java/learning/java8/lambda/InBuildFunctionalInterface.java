package com.us.java.learning.java8.lambda;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InBuildFunctionalInterface {
	
	public static void main(String[] args) {
		
		// Predicate : boolean test(T t);
		Predicate<Integer> predicate = i-> i<0;
		System.out.println("Is Given Number is Negative? "+predicate.test(-10));
		
		
		// BiPredicate : boolean test(T t, U u);
		BiPredicate<String, Integer> checkLength = (str,len) -> str.length() == len;
		System.out.println("Check Length test : "+ checkLength.test("Vatican City", 8));
		
		
		// Supplier : get();
		Supplier<StringBuilder> suplSupplierSB = () -> new StringBuilder();
		System.out.println("Supplier String Builder :"+suplSupplierSB.get().append(" SB"));
		
		Supplier<LocalTime> supplierTime = () -> LocalTime.now();
		System.out.println("Current Time : "+supplierTime.get());
		
		// Consumer : accept(T t);
		Consumer<String> printC = s -> System.out.println(s);
		printC.accept("Testing the Print functionality using consumer");
		
		List<String> nameList = new ArrayList<>();
		nameList.add("John");
		nameList.add("Marry");
		nameList.forEach(printC);
		
		// BiConsumer : accept(T t, U u);
		var mapCountryCities = new HashMap<String, String>();
		BiConsumer<String, String> biConsumer = (key,val) -> mapCountryCities.put(key, val);
		biConsumer.accept("Delhi", "India");
		biConsumer.accept("Washington DC", "USA");
		System.out.println(mapCountryCities);
		
		BiConsumer<String , String> mapPrint = (key, val) -> System.out.println(key +" is the capital of : "+val);
		mapCountryCities.forEach(mapPrint);
		
		// Function [It has two generic marker]: Function<T,R> --> R apply(T t);
		Function<String, Integer> stringLength = s -> s.length();
		System.out.println("Length of the string is : "+ stringLength.apply("United State of America"));
		
		// BiFunction [It takes two input and returns the generic R]: BiFunction<T, U, R>　R apply(T t, U u);
		BiFunction<String, String, Integer> biFunction = (s1, s2) -> s1.length() + s2.length();
		System.out.println("String length : "+ biFunction.apply("United State of", " America"));
		
		BiFunction<String, String, String> biFunctionConcat = (s1, s2) -> s1.concat(s2);
		System.out.println("Concat string result : "+ biFunctionConcat.apply("Capital of India is ", "Delhi"));
	}

	
}

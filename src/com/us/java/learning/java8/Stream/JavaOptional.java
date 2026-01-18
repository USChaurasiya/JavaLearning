package com.us.java.learning.java8.Stream;

import java.util.Optional;

public class JavaOptional {
	
	public static void main(String[] args) {
		Optional<Double> optAverage = calculateAvg(50, 60, 70);
		if(optAverage.isPresent())
			System.out.println("Average of the given Numbers : "+optAverage.get());
	}
	
	public static Optional<Double> calculateAvg(int... scores){
		
		if(scores.length == 0) return Optional.empty();
		int sum = 0;
		for(int score : scores) sum += score;
		return Optional.of((double)sum/scores.length);
	}

}

package com.us.java.learning.java8;

public interface Interface {
	
	interface Formula {
		
		double calculate(int a);

		default double sqrt(int a) {
			return Math.sqrt(isPositive(a));
		}

		static int isPositive(int a) {
			return a > 0 ? a : 0;
		}
	}

	public static void main(String[] args) {
		Formula formula = new Formula() {

			@Override
			public double calculate(int a) {

				return sqrt(a * 100);
			}
		};
		
		System.out.println(formula.calculate(100));
	}

}

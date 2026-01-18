package com.us.java.learning.java8.Stream;

public class Country {

	private String name, capital;

	public Country(String name, String capital) {
		this.name = name;
		this.capital = capital;
	}

	@Override
	public String toString() {
		
		return "Country Name = "+name+ " and Capital is : "+capital;
	}
}

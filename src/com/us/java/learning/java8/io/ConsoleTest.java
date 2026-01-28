package com.us.java.learning.java8.io;

import java.io.Console;
import java.util.Arrays;

/**
 * 
 */
public class ConsoleTest {

	public static void main(String[] args) {
		Console console = System.console();
		if (console == null) {
			System.err.println("Console not available.");
		} else {
			String name = console.readLine("Please enter your %s: ", "name");
			console.format("Hello There %s%n", name);
			console.printf("Welcome");
			console.writer().println();

			char[] pwd = console.readPassword("Enter password (between %d and %d Characters): ", 4, 10);
			char[] pwdAgain = console.readPassword("Verify Password");
			boolean pwdMatch = Arrays.equals(pwd, pwdAgain);

			if (pwdMatch) {
				console.printf("Password Match !");
			} else {
				console.printf("Password do Not Match !");
			}

		}
	}
}

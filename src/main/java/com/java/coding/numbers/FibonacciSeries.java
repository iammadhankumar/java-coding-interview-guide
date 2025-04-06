package com.java.coding.numbers;

import java.util.Scanner;

public class FibonacciSeries {

	/**
	 * Generates and prints the Fibonacci sequence up to a given number.
	 *
	 * This method efficiently computes the Fibonacci sequence by:
	 * 
	 * 1. Handling edge cases (negative numbers, 0, and 1).
	 * 
	 * 2. Starting with the first two Fibonacci numbers (0 and 1).
	 * 
	 * 3. Using an iterative approach to avoid recursion overhead.
	 * 
	 * 4. Stopping when the next Fibonacci number exceeds the given limit.
	 *
	 * Time Complexity: O(log N) (since Fibonacci numbers grow exponentially). 
	 * 
	 * Space Complexity: O(1) (only a few variables are used, no extra storage).
	 *
	 * @param number The upper limit for the Fibonacci sequence.
	 */
	public static void fibonacciSeries(long number) {
		if (number < 0) {
			System.out.println("Invalid input. Enter a non-negative number.");
			return; // Handle negative input
		}

		long a = 0, b = 1;
		System.out.print(a); // Print first Fibonacci number

		if (number == 0)
			return; // Edge case for 0

		System.out.print(" " + b); // Print second Fibonacci number

		while (true) {
			long next = a + b;
			if (next > number)
				break; // Stop when next term exceeds 'number'
			System.out.print(" " + next);
			a = b;
			b = next;
		}

		System.out.println(); // Add a new line for better formatting
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Prompt user for input
		System.out.print("Enter a number to get the Fibonacci series: ");
		long number = sc.nextLong();

		// Generate and print Fibonacci sequence
		System.out.print("Fibonacci sequence up to " + number + ": ");
		fibonacciSeries(number);

		sc.close(); // Close scanner to prevent resource leak
	}
}

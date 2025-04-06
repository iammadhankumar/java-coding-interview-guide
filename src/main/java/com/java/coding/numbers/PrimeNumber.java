package com.java.coding.numbers;

import java.util.Scanner;

public class PrimeNumber {

	/**
	 * Determines whether a given number is a prime number.
	 *
	 * This method optimally checks for primality by:
	 * 1. Handling edge cases (numbers <= 1, 2, and 3).
	 * 2. Eliminating even numbers and multiples of 3 early.
	 * 3. Using a loop to check divisibility for numbers of the form (6k ± 1),
	 * 4. reducing unnecessary checks and improving efficiency.
	 *
	 * Time Complexity: O(√N)
	 *
	 * @param number The number to check for primality.
	 * @return A message indicating whether the given number is prime or not.
	 */
	private static String findPrimeNumber(long number) {
		if (number <= 1)
			return "The Given Number is Not a Prime Number";
		if (number == 2 || number == 3)
			return "The Given Number is a Prime Number";
		if (number % 2 == 0 || number % 3 == 0)
			return "The Given Number is Not a Prime Number";

		for (long i = 5; i * i <= number; i += 6) {
			if (number % i == 0 || number % (i + 2) == 0) {
				return "The Given Number is Not a Prime Number";
			}
		}
		return "The Given Number is a Prime Number";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number to check if it is prime or not: ");
		long number = sc.nextLong(); // Read an long input

		System.out.println("Output:: " + findPrimeNumber(number));
		sc.close();
	}
}

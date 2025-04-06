package com.java.coding.numbers;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialNumber {

	/**
	 * Computes the factorial of a given number using BigInteger.
	 *
	 * Uses BigInteger to handle large factorial values (100! and beyond). 
	 * 
	 * Efficient iterative approach with O(N) time complexity.
	 *
	 * @param number The number whose factorial is to be calculated.
	 * @return The factorial of the given number as a BigInteger.
	 */
	private static BigInteger findFactorialNumber(long number) {
		BigInteger factorialNumber = BigInteger.ONE;

		while (number > 0) {
			factorialNumber = factorialNumber.multiply(BigInteger.valueOf(number));
			number--;
		}

		return factorialNumber;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Taking user input
		System.out.print("Enter a number to calculate factorial: ");
		long number = sc.nextLong();

		// Output the factorial result
		System.out.println("Factorial of " + number + " is: " + findFactorialNumber(number));

		sc.close(); // Close scanner
	}
}

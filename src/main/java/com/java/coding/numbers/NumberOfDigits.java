package com.java.coding.numbers;

import java.util.Scanner;

public class NumberOfDigits {

	/**
	 * Calculates the sum of digits of a given number.
	 *
	 * Time Complexity: O(log N) (Iterates through digits)
	 * Space Complexity: O(1)n(Uses only a few variables)
	 *
	 * @param number The input number.
	 * @return The sum of its digits.
	 */
	private static long findSumOfDigits(long number) {
		long sum = 0;
		while (number != 0) {
			sum += number % 10; // Extract last digit and add to sum
			number /= 10; // Remove last digit
		}
		return sum;
	}

	/**
	 * Recursively calculates the sum of digits.
	 *
	 * Time Complexity: O(log N) (one recursive call per digit) 
	 * Space Complexity: O(log N) (recursive call stack)
	 *
	 * @param number The input number.
	 * @return The sum of its digits.
	 */
	private static long findSumOfDigitsWithRecursive(long number) {
		if (number == 0)
			return 0;
		return (number % 10) + findSumOfDigitsWithRecursive(number / 10);
	}

	 /**
     * Computes the sum of digits using Java Streams.
     *
     * Time Complexity: O(log N) (since the number has log₁₀(N) digits).
     * Space Complexity: O(1) (minimal memory usage).
     *
     * @param number The input number.
     * @return The sum of its digits.
     */
    private static long findSumOfDigitsWithStream(long number) {
        return String.valueOf(number)
                     .chars()              // Convert to IntStream of ASCII values
                     .map(Character::getNumericValue)  // Convert characters to integers
                     .sum();               // Compute sum
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Taking user input
		System.out.print("Enter a number to calculate the sum of its digits: ");
		long number = sc.nextLong();

		// Output the sum of digits
		System.out.println("Sum of digits of " + number + " is (Iterative): " + findSumOfDigits(number));
		System.out.println("Sum of digits of " + number + " is (Recursive): " + findSumOfDigitsWithRecursive(number));
		System.out.println("Sum of digits of " + number + " is (Stream): " + findSumOfDigitsWithStream(number));

		sc.close(); // Close scanner
	}

}

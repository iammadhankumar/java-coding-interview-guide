package com.java.coding.numbers;

import java.util.Scanner;

public class PalindromeNumber {

	/**
	 * Checks if a number is a palindrome by reversing only half of it.
	 *
	 * Time Complexity: O(log N) - The loop runs approximately log₁₀(N) / 2 times,
	 * making it more efficient than fully reversing the number.
	 *
	 * Space Complexity: O(1) - Only a few extra variables (`reversedHalf` and
	 * `number`) are used, so no additional memory is required.
	 *
	 * @param number The number to check.
	 * @return true if the number is a palindrome, false otherwise.
	 */
	private static boolean isPalindromeNumber(long number) {
		if (number < 0 || (number % 10 == 0 && number != 0))
			return false; // Negative numbers and numbers ending in 0 (except 0) are not palindromes

		long reversedHalf = 0;
		while (number > reversedHalf) {
			reversedHalf = reversedHalf * 10 + number % 10; // Reverse only half
			number /= 10; // Reduce original number
		}

		// A palindrome must match the original first half and reversed second half
		return (number == reversedHalf || number == reversedHalf / 10);
	}

	/**
	 * Recursively checks if a number is a palindrome.
	 *
	 * Time Complexity: O(log N) (since we process digits, approximately log₁₀(N))
	 * 
	 * Space Complexity: O(log N) (due to recursive call stack)
	 *
	 * @param number   Remaining part of the original number.
	 * @param reversed The reversed number being formed.
	 * @param original The original number to compare at the base case.
	 * @return true if the number is a palindrome, false otherwise.
	 */
	private static boolean isPalindromeWithRecursive(long number, long reversed, long original) {
		if (number == 0) {
			return original == reversed; // Compare reversed number with original
		}
		return isPalindromeWithRecursive(number / 10, reversed * 10 + number % 10, original);
	}

	/**
	 * Checks if a given number is a palindrome using StringBuilder.
	 *
	 * Time Complexity: O(N) (where N is the number of digits, as reversing a string
	 * takes O(N))
	 * 
	 * Space Complexity: O(N) (since a new string is created for the reversed
	 * version)
	 *
	 * @param number The input number.
	 * @return true if the number is a palindrome, false otherwise.
	 */
	private static boolean isPalindromeWithStringBuilder(long number) {
		String str = String.valueOf(number);
		return str.equals(new StringBuilder(str).reverse().toString());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number to check if it is polindrome or not: ");
		long number = sc.nextLong(); // Read an long input

		System.out.println("Iterative:: Number " + number
				+ (isPalindromeNumber(number) ? " is a palindrome number." : "is NOT a palindrome number."));

		System.out.println("Recursive:: Number " + number
				+ (isPalindromeWithRecursive(number, 0, number) ? " is a palindrome number."
						: "is NOT a palindrome number."));

		System.out.println("StringBuilder:: Number " + number
				+ (isPalindromeWithStringBuilder(number) ? " is a palindrome number." : "is NOT a palindrome number."));
		sc.close();
	}

}

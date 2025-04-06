package com.java.coding.numbers;

import java.util.Scanner;

public class OddOrEven {

	/**
	 * This method determines whether a given number is even or odd.
	 * 
	 * Optimized Approach:
	 * 1. Uses the modulus operator (`% 2`), which is the fastest way to check for even or odd numbers.
	 * 2. Returns a result in constant time **O(1)**, making it highly efficient.
	 * 3. No loops or unnecessary computations, ensuring minimal resource usage.
	 *
	 * @param number The number to check.
	 * @return A string indicating whether the number is even or odd.
	 */
	public static String findOddOrEvenNumber(int number) {
		if (number % 2 == 0) {
			return "The Given Number is Even Number";
		} else {
			return "The Given Number is Odd Number";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number to check if it is odd or even: ");
		int number = sc.nextInt(); // Read an integer input

		System.out.println("Output:: " + findOddOrEvenNumber(number));
		sc.close();
	}

}

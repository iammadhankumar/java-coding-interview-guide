package com.java.coding.numbers;

import java.util.Scanner;

public class SwapNumbers {

	/**
	 * Swaps two numbers without using a third variable and prints the swapped
	 * values.
	 *
	 * @param a First number
	 * @param b Second number
	 */
	public static void swapWithAddition(long a, long b) {
		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println("After Swap (Addition Method): a = " + a + ", b = " + b);
	}

	/**
	 * Swaps two numbers using XOR bitwise operation and prints the swapped values.
	 *
	 * @param a First number
	 * @param b Second number
	 */
	public static void swapWithBitWise(long a, long b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println("After Swap (Bitwise XOR Method): a = " + a + ", b = " + b);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Taking user input
		System.out.print("Enter the First Number (a): ");
		long a = sc.nextLong();
		System.out.print("Enter the Second Number (b): ");
		long b = sc.nextLong();

		// Display original values
		System.out.println("Before Swap: a = " + a + ", b = " + b);

		// Perform swap using both methods
		swapWithAddition(a, b);
		swapWithBitWise(a, b);

		// Close scanner
		sc.close();
	}

}

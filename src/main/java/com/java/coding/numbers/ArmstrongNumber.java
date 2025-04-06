package com.java.coding.numbers;

import java.util.Scanner;

public class ArmstrongNumber {

	/**
	 * Checks if a given number is an Armstrong number.
	 *
	 * Time Complexity: O(d) - where d is the number of digits in the number.
	 * 
	 * Space Complexity: O(1) - only a few variables are used.
	 *
	 * @param number The number to check.
	 * @return true if the number is an Armstrong number, otherwise false.
	 */
	public static boolean isArmstrong(long number) {
		long sum = 0, temp = number;
		int digits = String.valueOf(number).length(); // Count digits

		while (temp > 0) {
			long digit = temp % 10;
			sum += Math.pow(digit, digits); // Raise digit to power of total digits
			temp /= 10;
		}

		return sum == number;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number to check if it's an Armstrong number: ");
		long number = sc.nextLong(); // Read an long input

		System.out
				.println("Number " + (isArmstrong(number) ? "is an Armstrong number." : "is NOT an Armstrong number."));
		sc.close();
	}

}

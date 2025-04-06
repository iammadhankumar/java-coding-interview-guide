package com.java.coding.numberlist;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Utility class to demonstrate ways of counting
 * positive and negative numbers using Java Streams.
 */
public class PositiveNegativeNumberCounter {

	/**
	 * Counts positive numbers using filter and count.
	 *
	 * ✅ Simple and efficient
	 * ✅ Time Complexity: O(n)
	 */
	private static long countPositiveNumbers(List<Integer> list) {
		return list.stream()
				.filter(num -> num > 0)
				.count();
	}

	/**
	 * Counts negative numbers using filter and count.
	 *
	 * ✅ Simple and efficient
	 * ✅ Time Complexity: O(n)
	 */
	private static long countNegativeNumbers(List<Integer> list) {
		return list.stream()
				.filter(num -> num < 0)
				.count();
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the list of integers (separated by space): ");
			List<Integer> integerList = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
					.map(Integer::parseInt)
					.collect(Collectors.toList());

			if (integerList.isEmpty()) {
				System.out.println("No integers provided.");
				return;
			}


			 System.out.println("Count of positive numbers: " + countPositiveNumbers(integerList));
		     System.out.println("Count of negative numbers: " + countNegativeNumbers(integerList));
		}
	}

}

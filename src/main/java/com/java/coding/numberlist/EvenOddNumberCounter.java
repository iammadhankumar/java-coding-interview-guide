package com.java.coding.numberlist;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Utility class to demonstrate various ways of counting
 * even and odd numbers from a list using Java Streams.
 */
public class EvenOddNumberCounter {

	/**
	 * Counts even numbers using filter and count.
	 *
	 * ✅ Simple and efficient
	 * ✅ Time Complexity: O(n)
	 */
	private static long countEvenNumbers(List<Integer> list) {
		return list.stream()
				.filter(num -> num % 2 == 0)
				.count();
	}

	/**
	 * Counts odd numbers using filter and count.
	 *
	 * ✅ Simple and efficient
	 * ✅ Time Complexity: O(n)
	 */
	private static long countOddNumbers(List<Integer> list) {
		return list.stream()
				.filter(num -> num % 2 != 0)
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


			System.out.println("Count of even numbers: " + countEvenNumbers(integerList));
			System.out.println("Count of odd numbers: " + countOddNumbers(integerList));
		}
	}

}

package com.java.coding.numberlist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Utility class to demonstrate various ways of finding the maximum value
 * from a list of integers using Java Streams.
 */
public class ListMaximumFinder {


	/**
	 * Finds the maximum value using primitive stream (mapToInt).
	 *
	 * ✅ Most efficient approach
	 * ✅ Avoids boxing/unboxing overhead
	 * ✅ Time Complexity: O(n)
	 */
	private static int findMaxUsingMapToInt(List<Integer> list) {
		return list.stream()
				.mapToInt(Integer::intValue)
				.max()
				.orElseThrow();
	}

	/**
	 * Finds the maximum value using Stream.max with Integer::compareTo.
	 *
	 * ✅ Efficient approach
	 * ⚠️ Slight boxing overhead
	 * ✅ Time Complexity: O(n)
	 */
	private static int findMaxUsingIntegerCompare(List<Integer> list) {
		return list.stream()
				.max(Integer::compareTo)
				.orElseThrow();
	}

	/**
	 * Finds the maximum value using Stream.reduce with Integer::max.
	 *
	 * ✅ Functional and readable
	 * ⚠️ Similar performance to max(), but with slight overhead
	 * ✅ Time Complexity: O(n)
	 */
	private static int findMaxUsingReduce(List<Integer> list) {
		return list.stream()
				.reduce(Integer::max)
				.orElseThrow();
	}

	/**
	 * Finds the maximum value using Stream.max with Comparable::compareTo.
	 *
	 * ✅ Equivalent to Integer::compareTo (since Integer implements Comparable)
	 * ✅ Time Complexity: O(n)
	 */
	private static int findMaxUsingComparableCompare(List<Integer> list) {
		return list.stream()
				.max(Comparable::compareTo)
				.orElseThrow();
	}

	/**
	 * Finds the maximum value by sorting the list in reverse order and returning the first element.
	 *
	 * ❌ Inefficient approach
	 * ❌ Entire list is sorted unnecessarily
	 * ❌ Time Complexity: O(n log n)
	 */
	private static int findMaxUsingSorted(List<Integer> list) {
		return list.stream()
				.sorted(Comparator.reverseOrder())
				.findFirst()
				.orElseThrow();
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

			System.out.println("Max using mapToInt: " + findMaxUsingMapToInt(integerList));
			System.out.println("Max using Integer::compareTo: " + findMaxUsingIntegerCompare(integerList));
			System.out.println("Max using reduce & Integer::max: " + findMaxUsingReduce(integerList));
			System.out.println("Max using Comparable::compareTo: " + findMaxUsingComparableCompare(integerList));
			System.out.println("Max using sorted & findFirst: " + findMaxUsingSorted(integerList));
		}
	}

}

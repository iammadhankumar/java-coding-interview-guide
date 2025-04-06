package com.java.coding.numberlist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Utility class to demonstrate various ways of finding the minimum value
 * from a list of integers using Java Streams.
 */
public class ListMinimumFinder {

	/**
	 * Finds the minimum value using primitive stream (mapToInt).
	 *
	 * ✅ Most efficient approach
	 * ✅ Avoids boxing/unboxing overhead
	 * ✅ Time Complexity: O(n)
	 */
	private static int findMinUsingMapToInt(List<Integer> list) {
		return list.stream()
				.mapToInt(Integer::intValue)
				.min()
				.orElseThrow();
	}

	/**
	 * Finds the minimum value using Stream.min with Integer::compareTo.
	 *
	 * ✅ Efficient approach
	 * ⚠️ Slight boxing overhead
	 * ✅ Time Complexity: O(n)
	 */
	private static int findMinUsingIntegerCompare(List<Integer> list) {
		return list.stream()
				.min(Integer::compareTo)
				.orElseThrow();
	}

	/**
	 * Finds the minimum value using Stream.reduce with Integer::min.
	 *
	 * ✅ Functional and readable
	 * ⚠️ Slight overhead due to boxing
	 * ✅ Time Complexity: O(n)
	 */
	private static int findMinUsingReduce(List<Integer> list) {
		return list.stream()
				.reduce(Integer::min)
				.orElseThrow();
	}

	/**
	 * Finds the minimum value using Stream.min with Comparable::compareTo.
	 *
	 * ✅ Equivalent to Integer::compareTo
	 * ✅ Time Complexity: O(n)
	 */
	private static int findMinUsingComparableCompare(List<Integer> list) {
		return list.stream()
				.min(Comparable::compareTo)
				.orElseThrow();
	}

	/**
	 * Finds the minimum value by sorting the list in natural order and returning the first element.
	 *
	 * ❌ Inefficient: sorts the entire list unnecessarily
	 * ❌ Time Complexity: O(n log n)
	 */
	private static int findMinUsingSorted(List<Integer> list) {
		return list.stream()
				.sorted(Comparator.naturalOrder())
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

			System.out.println("Min using mapToInt: " + findMinUsingMapToInt(integerList));
			System.out.println("Min using Integer::compareTo: " + findMinUsingIntegerCompare(integerList));
			System.out.println("Min using reduce & Integer::min: " + findMinUsingReduce(integerList));
			System.out.println("Min using Comparable::compareTo: " + findMinUsingComparableCompare(integerList));
			System.out.println("Min using sorted & findFirst: " + findMinUsingSorted(integerList));
		}
	}

}

package com.java.coding.numberlist;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Utility class to demonstrate various ways of calculating
 * the sum of integers from a list using Java Streams and traditional approaches.
 */
public class ListTotalSumFinder {

	/**
	 * Calculates the sum using primitive stream mapToInt.
	 *
	 * ✅ Most efficient approach (no boxing/unboxing)
	 * ✅ Time Complexity: O(n)
	 */
	private static int sumUsingMapToInt(List<Integer> list) {
		return list.stream()
				.mapToInt(Integer::intValue)
				.sum();
	}

	/**
	 * Calculates the sum using Stream.reduce with Integer::sum.
	 *
	 * ✅ Functional and expressive
	 * ⚠️ Slight boxing/unboxing overhead
	 * ✅ Time Complexity: O(n)
	 */
	private static int sumUsingReduce(List<Integer> list) {
		return list.stream()
				.reduce(0, Integer::sum);
	}

	/**
	 * Calculates the sum using Collectors.summingInt.
	 *
	 * ✅ Clean and composable in collector chains
	 * ⚠️ Minor overhead due to collector abstraction
	 * ✅ Time Complexity: O(n)
	 */
	private static int sumUsingCollectors(List<Integer> list) {
		return list.stream()
				.collect(Collectors.summingInt(Integer::intValue));
	}

	/**
	 * Calculates the sum using a traditional for-each loop.
	 *
	 * ✅ Simple and efficient
	 * ✅ No overhead from streams
	 * ✅ Time Complexity: O(n)
	 */
	private static int sumUsingForEach(List<Integer> list) {
		int sum = 0;
		for (int num : list) {
			sum += num;
		}
		return sum;
	}

	/**
	 * Calculates the sum using IntSummaryStatistics.
	 *
	 * ✅ Useful when you need sum + min/max/avg/count
	 * ⚠️ Slightly more computation involved
	 * ✅ Time Complexity: O(n)
	 */
	private static int sumUsingSummaryStatistics(List<Integer> list) {
		return (int) list.stream()
				.mapToInt(Integer::intValue)
				.summaryStatistics()
				.getSum();
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

			System.out.println("Sum using mapToInt: " + sumUsingMapToInt(integerList));
	        System.out.println("Sum using reduce & Integer::sum: " + sumUsingReduce(integerList));
	        System.out.println("Sum using Collectors.summingInt: " + sumUsingCollectors(integerList));
	        System.out.println("Sum using traditional loop: " + sumUsingForEach(integerList));
	        System.out.println("Sum using IntSummaryStatistics: " + sumUsingSummaryStatistics(integerList));
		}
	}

}

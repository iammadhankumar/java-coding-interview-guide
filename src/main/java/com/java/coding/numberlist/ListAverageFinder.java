package com.java.coding.numberlist;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Utility class to demonstrate various ways of calculating
 * the average of integers from a list using Java Streams and traditional approaches.
 */
public class ListAverageFinder {

	/**
	 * Calculates the average using mapToDouble and average.
	 *
	 * ✅ Most efficient and direct approach
	 * ✅ Uses primitive stream (double), avoids boxing
	 * ✅ Time Complexity: O(n)
	 */
	private static double averageUsingMapToDouble(List<Integer> list) {
		return list.stream()
				.mapToDouble(Integer::doubleValue)
				.average()
				.orElseThrow();
	}

	/**
	 * Calculates the average using Collectors.averagingInt.
	 *
	 * ✅ Declarative and readable
	 * ⚠️ Slight overhead due to collector abstraction
	 * ✅ Time Complexity: O(n)
	 */
	private static double averageUsingCollectors(List<Integer> list) {
		return list.stream()
				.collect(Collectors.averagingInt(Integer::intValue));
	}

	/**
	 * Calculates the average using IntSummaryStatistics.
	 *
	 * ✅ Useful when multiple statistics (min, max, sum, count, avg) are needed
	 * ⚠️ Slightly more costly than direct average due to extra stats computation
	 * ✅ Time Complexity: O(n)
	 */
	private static double averageUsingSummaryStatistics(List<Integer> list) {
		return list.stream()
				.mapToInt(Integer::intValue)
				.summaryStatistics()
				.getAverage();
	}

	/**
	 * Calculates the average manually by summing and dividing by size.
	 *
	 * ✅ Fine-grained control
	 * ⚠️ Less elegant; not preferred unless customization is needed
	 * ✅ Time Complexity: O(n)
	 */
	private static double averageUsingManualMethod(List<Integer> list) {
		int sum = 0;
		for (int num : list) {
			sum += num;
		}
		return (double) sum / list.size();
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

			System.out.println("Average using mapToDouble: "+averageUsingMapToDouble(integerList));
	        System.out.println("Average using Collectors.averagingInt: "+averageUsingCollectors(integerList));
	        System.out.println("Average using IntSummaryStatistics: "+averageUsingSummaryStatistics(integerList));
	        System.out.println("Average using manual calculation: "+averageUsingManualMethod(integerList));
		}
	}

}

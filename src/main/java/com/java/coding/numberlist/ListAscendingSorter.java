package com.java.coding.numberlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Demonstrates various ways to sort a list of integers in ascending order.
 */
public class ListAscendingSorter {

	// 1. Using stream().sorted()
	// ✅ Most concise and idiomatic
	// ✅ Time Complexity: O(n log n)
	private static List<Integer> sortWithStream(List<Integer> list) {
		return list.stream()
				.sorted()
				.collect(Collectors.toList());
	}

	// 2. Using stream().sorted(Comparator.naturalOrder())
	// ✅ Explicit natural order comparator
	// ✅ Time Complexity: O(n log n)
	private static List<Integer> sortWithNaturalOrder(List<Integer> list) {
		return list.stream()
				.sorted(Comparator.naturalOrder())
				.collect(Collectors.toList());
	}

	// 3. Using custom comparator with compareTo
	// ✅ Verbose but flexible
	// ✅ Time Complexity: O(n log n)
	private static List<Integer> sortWithCompareTo(List<Integer> list) {
		return list.stream()
				.sorted((a, b) -> a.compareTo(b))
				.collect(Collectors.toList());
	}

	// 4. Using Collections.sort() with defensive copy
	// ✅ Traditional and in-place
	// ✅ Time Complexity: O(n log n)
	private static List<Integer> sortWithCollectionsSort(List<Integer> list) {
		List<Integer> copy = new ArrayList<>(list);
		Collections.sort(copy);
		return copy;
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

			System.out.println("1. Sorted using stream().sorted(): " + sortWithStream(integerList));
			System.out.println("2. Sorted using Comparator.naturalOrder(): " + sortWithNaturalOrder(integerList));
			System.out.println("3. Sorted using lambda compareTo: " + sortWithCompareTo(integerList));
			System.out.println("4. Sorted using Collections.sort(): " + sortWithCollectionsSort(integerList));
		}
	}

}

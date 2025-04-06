package com.java.coding.numberlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListDescendingSorter {

	// 1. Using Comparator.reverseOrder()
	// ✅ Simple and idiomatic
	// ✅ Time Complexity: O(n log n)
	private static List<Integer> sortWithDescOrder(List<Integer> list) {
		return list.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
	}

	// 2. Using custom comparator with compareTo (b.compareTo(a))
	// ✅ Flexible for future comparator enhancements
	// ✅ Time Complexity: O(n log n)
	private static List<Integer> sortWithCustomDescCompare(List<Integer> list) {
		return list.stream()
				.sorted((a, b) -> b.compareTo(a))
				.collect(Collectors.toList());
	}

	// 3. Using Collections.sort with custom comparator
	// ✅ Traditional approach, sorts a mutable copy
	// ✅ Time Complexity: O(n log n)
	private static List<Integer> sortWithCollectionsReverse(List<Integer> list) {
		List<Integer> copy = new ArrayList<>(list);
		copy.sort((a, b) -> b - a); // OR Collections.sort(copy, Comparator.reverseOrder());
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

	        System.out.println("Sorted desc using Comparator.reverseOrder(): " + sortWithDescOrder(integerList));
	        System.out.println("Sorted desc using lambda with compareTo: " + sortWithCustomDescCompare(integerList));
	        System.out.println("Sorted desc using Collections.sort() + custom comparator: " + sortWithCollectionsReverse(integerList));
		}
	}

}

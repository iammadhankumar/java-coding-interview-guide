package com.java.coding.numberlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Utility class demonstrating different ways to reverse a list.
 */
public class ListReverser {

	/**
	 * 1. Using Collections.reverse() - In-place reversal
	 *
	 * ✅ Most efficient and simple for mutable lists
	 * ✅ Time Complexity: O(n)
	 */
	private static List<Integer> reverseWithCollections(List<Integer> list) {
		List<Integer> copy = new ArrayList<>(list); // Defensive copy to preserve original
		Collections.reverse(copy);
		return copy;
	}

	/**
	 * 2. Using ListIterator - Manual reverse traversal
	 *
	 * ✅ Safe method without mutating original list
	 * ✅ Time Complexity: O(n)
	 */
	private static List<Integer> reverseWithIterator(List<Integer> list) {
		List<Integer> reversed = new ArrayList<>();
		ListIterator<Integer> iterator = list.listIterator(list.size());
		while (iterator.hasPrevious()) {
			reversed.add(iterator.previous());
		}
		return reversed;
	}

	/**
	 * 3. Using Java 8 Stream + Index-based access
	 *
	 * ✅ Functional and concise
	 * ⚠️ Slightly slower due to random access (list.get())
	 * ✅ Time Complexity: O(n)
	 */
	private static List<Integer> reverseWithStreamIndex(List<Integer> list) {
		return IntStream.rangeClosed(1, list.size())
				.mapToObj(i -> list.get(list.size() - i))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the list of integers (separated by space): ");
			List<Integer> originalList = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
					.map(Integer::parseInt)
					.collect(Collectors.toList());

			if (originalList.isEmpty()) {
				System.out.println("No integers provided.");
				return;
			}

			System.out.println("Reversed using Collections.reverse(): " + reverseWithCollections(originalList));
			System.out.println("Reversed using ListIterator: " + reverseWithIterator(originalList));
			System.out.println("Reversed using Stream (index-based): " + reverseWithStreamIndex(originalList));
		}
	}

}

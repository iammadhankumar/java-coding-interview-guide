package com.java.coding.numbers;

import java.util.Scanner;

public class ReverseNumber {
	/**
     * Reverses the given number efficiently using arithmetic operations.
     *
     * Time Complexity: O(log N) - The number has log₁₀(N) digits.
     * Space Complexity: O(1) - Uses only a few variables.
     *
     * @param number The number to be reversed.
     * @return The reversed number.
     */
    public static long reverseNumber(long number) {
        long reversed = 0;
        while (number != 0) {
            reversed = reversed * 10 + number % 10; // Extract and append last digit
            number /= 10; // Remove last digit
        }
        return reversed;
    }

    /**
     * Recursively reverses the given number.
     *
     * Time Complexity: O(log N) - Since the number has approximately log₁₀(N) digits,
     *                                  the recursion runs for that many steps.
     * Space Complexity: O(log N) - Due to recursive function calls, stack space is used
     *                                  for each digit in the number.
     *
     * @param number The number to be reversed.
     * @param reversed The reversed number being formed.
     * @return The fully reversed number.
     */
    private static long reverseNumberRecursive(long number, long reversed) {
        if (number == 0) {
            return reversed; // Base case: all digits processed
        }
        return reverseNumberRecursive(number / 10, reversed * 10 + number % 10);
    }
    
    /**
     * Reverses the given number using StringBuilder.
     *
     * Time Complexity: O(N) - N is the number of digits.
     * Space Complexity: O(N) - Uses extra space for the string representation.
     *
     * @param number The number to be reversed.
     * @return The reversed number.
     */
    public static long reverseNumberUsingStringBuilder(long number) {
        String reversedStr = new StringBuilder(String.valueOf(number))
                .reverse()
                .toString();
        return Long.parseLong(reversedStr);
    }


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number to reverse: ");
            long number = scanner.nextLong();

            // Display results
            System.out.println("Reversed Number (Iterative): " + reverseNumber(number));
            System.out.println("Reversed Number (Recursive): " + reverseNumberRecursive(number, 0));
            System.out.println("Reversed Number (Using StringBuilder): " + reverseNumberUsingStringBuilder(number));

        }
    }
}

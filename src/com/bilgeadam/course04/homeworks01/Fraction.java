package com.bilgeadam.course04.homeworks01;

import java.util.Scanner;

public class Fraction {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to Fraction Calculator");
		operationMenu(true);

		System.out.println("Bye...");

	}

	private static void operationSelection(char choice) {
		switch (choice) {
		case '1':
			addittion();
			break;
		case '2':
			multipleAddittion();
			break;
		case '3':
			extraction();
			break;
		case '4':
			multiplication();
			break;
		case '5':
			division();
			break;

		default:
			System.err.println("Invalid Entry!");
			break;
		}

	}

	private static void multipleAddittion() {
		inputMultipleAdditionFormat();
	}

	private static void inputMultipleAdditionFormat() {
		System.out.println("This operation format is: a1/b1 + a2/b2 + ...... + aN/bN");
		System.out.print("How many fraction do you want to add(N): ");
		int[][] multipleAdditionArray = createMultipleAddittionArray(scan.nextInt());
		int[] numerators = new int[multipleAdditionArray.length];
		int numerator = 0;
		int denominator = 1;

		for (int i = 0; i < multipleAdditionArray.length; i++) {
			numerators[i] = multipleAdditionArray[i][0];
			denominator *= multipleAdditionArray[i][1];
			for (int j = 0; j < multipleAdditionArray.length; j++) {
				numerators[i] *= (j == i ? 1 : multipleAdditionArray[j][1]);
			}
		}

		for (int i = 0; i < numerators.length; i++) {
			numerator += numerators[i];
		}
		
		System.out.println("----------------------------------------");
		printMultipleAddittion(multipleAdditionArray);
		printResult(numerator, denominator);

		operationMenu(true);

	}

	private static void printMultipleAddittion(int[][] multipleAdditionArray) {
		for (int i = 0; i < multipleAdditionArray.length; i++) {
			System.out.print("( " + multipleAdditionArray[i][0] + " / " + multipleAdditionArray[i][1] + " )");
			System.out.print((i != multipleAdditionArray.length - 1) ? " + " : "\n");
		}

	}

	private static int[][] createMultipleAddittionArray(int arrayLength) {
		int[][] multipleAddittionArray = new int[arrayLength][2];

		for (int i = 0; i < arrayLength; i++) {
			System.out.print((i + 1) + ". fraction numerator is: ");
			multipleAddittionArray[i][0] = scan.nextInt();
			System.out.print((i + 1) + ". fraction denominator is: ");
			multipleAddittionArray[i][1] = scan.nextInt();
		}
		return multipleAddittionArray;
	}

	private static void division() {
		inputFormat('/');
		int[] numbers = inputScreen();
		calculate("/", numbers);

	}

	private static void multiplication() {
		inputFormat('*');
		int[] numbers = inputScreen();
		calculate("*", numbers);

	}

	private static void extraction() {
		inputFormat('-');
		int[] numbers = inputScreen();
		calculate("-", numbers);

	}

	private static void addittion() {
		inputFormat('+');
		int[] numbers = inputScreen();
		calculate("+", numbers);

	}

	private static void calculate(String string, int[] numbers) {
		switch (string) {
		case "+":
			calculateAddition(numbers);
			break;
		case "-":
			calculateExtraction(numbers);
			break;
		case "*":
			calculateMultiplication(numbers);
			break;
		case "/":
			calculateDivision(numbers);
			break;
		default:
			break;
		}

	}

	private static void calculateDivision(int[] numbers) {
		int numerator = numbers[0] * numbers[3];
		int denominator = numbers[1] * numbers[2];

		printResult(numerator, denominator);

		operationMenu(true);

	}

	private static void calculateMultiplication(int[] numbers) {
		int numerator = numbers[0] * numbers[2];
		int denominator = numbers[1] * numbers[3];

		printResult(numerator, denominator);

		operationMenu(true);

	}

	private static void calculateExtraction(int[] numbers) {
		int numerator = numbers[0] * numbers[3] - numbers[1] * numbers[2];
		int denominator = numbers[1] * numbers[3];

		printResult(numerator, denominator);

		operationMenu(true);

	}

	private static void calculateAddition(int[] numbers) {
		int numerator = numbers[0] * numbers[3] + numbers[1] * numbers[2];
		int denominator = numbers[1] * numbers[3];

		printResult(numerator, denominator);

		operationMenu(true);

	}

	private static void printResult(int numerator, int denominator) {

		System.out.println("========================================");

		int bcd = calculateBcd(numerator, denominator); // calculate the Biggest Common Divisor
		int newNumerator = -1 * (numerator / (Math.abs(bcd) * -1));
		int newDenominator = Math.abs(denominator / bcd);
		System.err.println("Result is: " + ((newNumerator % newDenominator == 0) ? newNumerator / newDenominator
				: newNumerator + " / " + newDenominator));
	}

	private static int calculateBcd(int numerator, int denominator) {

		int bcd = 0;
		boolean positiveBcd = true;

		if (numerator < 0) {
			positiveBcd = false;
			numerator *= -1;
		}

		if (denominator > numerator) {
			for (int i = 1; i <= numerator; i++) {
				if (numerator % i == 0 && denominator % i == 0) {
					bcd = i;
				}
			}
		} else {
			for (int i = 1; i <= denominator; i++) {
				if (numerator % i == 0 && denominator % i == 0) {
					bcd = i;
				}
			}
		}
		return positiveBcd ? bcd : -bcd;
	}

	private static int[] inputScreen() {
		int[] numbers = new int[4];
		System.out.print("Enter A: ");
		numbers[0] = scan.nextInt();
		System.out.print("Enter B: ");
		numbers[1] = scan.nextInt();
		System.out.print("Enter C: ");
		numbers[2] = scan.nextInt();
		System.out.print("Enter D: ");
		numbers[3] = scan.nextInt();

		return numbers;
	}

	private static void inputFormat(char c) {
		System.out.println("This operation's format is");
		System.out.println(" A / B " + c + " C / D");

	}

	private static boolean choiceController(String choice) {

		System.out.println("========================================");

		if (choice.length() == 1) {
			if (choice.toLowerCase().charAt(0) == 'e')
				return false;
			else
				operationSelection(choice.charAt(0));
			return false;
		} else {
			System.err.println("Invalid Entry!");
			return true;
		}

	}

	private static void operationMenu(boolean b) {

		while (b) {
			System.out.println("----------------------------------------");
			System.out.println("#1 - Addition");
			System.out.println("#2 - Multiple Addition");
			System.out.println("#3 - Extraction");
			System.out.println("#4 - Multiplication");
			System.out.println("#5 - Division");
			System.out.println("#e - If you want to quit just enter 'e'\n");
			System.out.print("Choose your operation: ");
			String choice = scan.next();

			b = choiceController(choice);
		}
	}

}

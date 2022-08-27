package com.bilgeadam.course04.homeworks01;

import java.util.Scanner;

public class EthiopianMultiplication {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Ethiopia!");
		System.out.print("Enter the first number for multiply: ");
		int number1 = scan.nextInt();
		System.out.print("Enter the second number for multiply: ");
		int number2 = scan.nextInt();
		scan.close();

		ethiophianMultiply(number1, number2);
		
		System.out.println("Bye...");

	}

	private static void ethiophianMultiply(int number1, int number2) {

		int multiply = 0;

		while (number1 > 0) {
			if (number1 % 2 == 0)
				System.err.println("\t" + number1 + " - " + number2);
			else {
				System.out.println("\t" + number1 + " - " + number2);
				multiply += number2;
			}
			number1 /= 2;
			number2 *= 2;
		}
		System.out.println("--------------------");
		System.out.println("Result = " + multiply);

	}

}

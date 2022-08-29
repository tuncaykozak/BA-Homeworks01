package com.bilgeadam.course04.homeworks01;

import java.util.Scanner;

public class Backtracking {

	public static void main(String[] args) {

		System.out.println("Welcome to Reversing a Word");
		readInput();

		System.out.println("Bye...");

	}
	
	// Solution with Recursive:
	
	private static void reversingWord(String word, String reversedWord) {

		if (word.length() > 0) {
			reversedWord += word.charAt(word.length() - 1);
			String reversingWord = "";
			for (int i = 0; i < word.length() - 1; i++) {
				reversingWord += word.charAt(i);
			}
			reversingWord(reversingWord, reversedWord);
		} else
			System.out.println("Reversed word is: " + reversedWord);
	}

	private static void readInput() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String reversedWord = "";
		reversingWord(scan.nextLine(), reversedWord);
		scan.close();
	}

	// Solution without Recursive:
	
//	private static void reversingWord(String word) {
//		String reversedWord = "";
//		
//		for(int i = word.length() - 1; i >= 0; i--) {
//			reversedWord += word.charAt(i);
//		}
//		System.out.println("Reversed word is: " + reversedWord);
//	}
//	
//
//	private static void readInput() {
//		Scanner scan = new Scanner(System.in);
//		System.out.print("Enter a word: ");
//		reversingWord(scan.nextLine());
//		scan.close();	
//	}
}

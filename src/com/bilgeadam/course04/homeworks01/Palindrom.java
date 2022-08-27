package com.bilgeadam.course04.homeworks01;

import java.util.Scanner;

public class Palindrom {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String word = scan.nextLine();
		System.out.println(word + (isPalindrom(word) ? " is Palindorm" : " is not Palindrom"));
		scan.close();
		System.out.println("Bye...");

	}

	private static boolean isPalindrom(String word) {
		
		boolean isPalindrom = false;
		
		for(int i = 0; i < word.length() / 2; i++ ) {
			isPalindrom = (word.charAt(i) == word.charAt(word.length() -(i + 1) ));
		}
		return isPalindrom;
		
	}

}

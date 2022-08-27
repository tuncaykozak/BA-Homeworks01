package com.bilgeadam.course04.homeworks01;

import java.util.Scanner;

public class CakesForKids {
	
	private static Scanner scan; 

	public static void main(String[] args) {
		
		System.out.println("Bonne Appetite");
		scan = new Scanner(System.in);
		readInput();
		scan.close();
		System.out.println("Bye...");
		

	}

	private static void readInput() {
		
		calculateProbabilities();
		
	}

	private static void calculateProbabilities() {
		printProbabilities();
		
	}

	private static void printProbabilities() {
		
		
	}

}

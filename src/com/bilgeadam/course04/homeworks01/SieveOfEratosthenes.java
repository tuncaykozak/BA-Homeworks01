package com.bilgeadam.course04.homeworks01;

import java.util.Scanner;

/**
 * A prime number is a natural number that has exactly two distinct natural
 * number divisors: the number 1 and itself.
 * 
 * To find all the prime numbers less than or equal to a given integer n by
 * 'Eratosthenes' method:
 * 
 * 1- Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
 * 2- Initially, let p equal 2, the smallest prime number.
 * 3- Enumerate the multiples of p by counting in increments of p from 2p to n, 
 * and mark them in the list (these will be 2p, 3p, 4p, ...; the p itself should not be marked).
 * 4- Find the smallest number in the list greater than p that is not marked. If
 * there was no such number, stop. Otherwise, let p now equal this new number
 * (which is the next prime), and repeat from step 3.
 * 5- When the algorithm terminates, the numbers remaining not marked in the list 
 * are all the primes below n.
 * 
 * reference = https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 */

public class SieveOfEratosthenes {

	private Scanner scan;

	public static void main(String[] args) {
		
		SieveOfEratosthenes sieve = new SieveOfEratosthenes();
		sieve.scan = new Scanner(System.in);
		sieve.findPrimeNumbers();
		sieve.scan.close();

		System.out.println("Bye...");
	}

	private void findPrimeNumbers() {
		
		System.out.println("Welcome to Sieve of Eartosthenes!");
		int number = numberInput();
		int[][] numbers = sieveArray(number);

		// before start: 
		// We know 1 is not a prime number and can't work this method (we signed every number isPrime)
		// and also we know 2 is the smallest prime number then we can start from 2

		numbers[0][1] = 0;

		for (int i = 1; i < number; i++) {
			if (numbers[i][1] == 1) {
				System.err.print(numbers[i][0] + ":");
				wait(200);
				printNotPrimeNumbers(numbers, numbers[i][0]);
			}
		}
		printPrimeNumbers(numbers);
	}

	private void printNotPrimeNumbers(int[][] numbers, int primeNumber) {
		
		for (int i = primeNumber; i < numbers.length; i++) {
			if (numbers[i][1] == 1 && numbers[i][0] % primeNumber == 0) {
				System.out.print(" " + numbers[i][0]);
				numbers[i][1] = 0;
				wait(50);
			}
		}
		System.out.println();
	}

	private void printPrimeNumbers(int[][] numbers) {
		System.out.println("------------------");
		System.out.print("Prime numbers are: ");
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i][1] == 1) {
				System.err.print(numbers[i][0] + " ");
				wait(300);
			}
		}
		System.out.println();
	}

	private int[][] sieveArray(int number) {

		int[][] numbers = new int[number][2];
		for (int i = 0; i < number; i++) {
			numbers[i][0] = i + 1;
			numbers[i][1] = 1; // second dimension => will signed like boolean isPrime = 1 ~ !isPrime = 0
		}
		return numbers;
	}

	private int numberInput() {

		System.out.print("We will find the prime numbers till 'n'. Enter 'n': ");
		return scan.nextInt();
	}
	
	private void wait(int time) {
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

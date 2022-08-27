package com.bilgeadam.course04.homeworks01;

import java.util.Scanner;

public class SieveOfEratosthenes {
	
	private  Scanner scan;
	
	public static void main(String[] args) {
		/**
		 * A prime number is a natural number that has exactly two distinct natural
		 * number divisors: the number 1 and itself.
		 * 
		 * To find all the prime numbers less than or equal to a given integer n by
		 * 'Eratosthenes' method:
		 * 
		 * 1- Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
		 * 2- Initially, let p equal 2, the smallest prime number. 3- Enumerate the
		 * multiples of p by counting in increments of p from 2p to n, and mark them in
		 * the list (these will be 2p, 3p, 4p, ...; the p itself should not be marked).
		 * 4- Find the smallest number in the list greater than p that is not marked. If
		 * there was no such number, stop. Otherwise, let p now equal this new number
		 * (which is the next prime), and repeat from step 3. 5- When the algorithm
		 * terminates, the numbers remaining not marked in the list are all the primes
		 * below n.
		 */
		
		SieveOfEratosthenes sieve = new SieveOfEratosthenes();
		sieve.scan = new Scanner(System.in);
		sieve.findPrimeNumber();
		
		sieve.scan.close();
		System.out.println("Bye...");
	}

	private void findPrimeNumber() {
		System.out.println("Welcome to Sieve of Eartosthenes!");
		numberInput();		
	}

	private void numberInput() {
		System.out.println("We will calculate the prime ");
		
	}

}

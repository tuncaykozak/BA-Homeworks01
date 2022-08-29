package com.bilgeadam.course04.homeworks01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CakesForKids {

	private static Scanner scan;

	public static void main(String[] args) {

		System.out.println("Bonne Appetite!");
		scan = new Scanner(System.in);
		readInput();
		scan.close();
		System.out.println("-------------------------------");
		System.out.println("Bye...");

	}

	private static void readInput() {
		System.out.print("Enter the cakes' number: ");
		int c = scan.nextInt();
		System.out.print("Enter the kids' number: ");
		int k = scan.nextInt();
		System.out.println("-------------------------------");
		possibilities(c, k);

	}

	private static void possibilities(int c, int k) {
		int beginning = 65;
		char[] cakes = new char[c * k];
		int index = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < k; j++) {
				cakes[index] = (char) (beginning + i);
				index++;
			}
		}
		for (int i = 0; i < k; i++) {
			System.out.print("Kid-" + (i + 1) + "\t");
		}
		System.out.println();
		ArrayList<String> outputs = permute(cakes, 0, c, k, new ArrayList<String>());

		Collections.sort(outputs);
		// outputs.sort(Comparator.naturalOrder());
		Set<String> set = new HashSet<>(outputs);
		outputs.clear();
		outputs.addAll(set);
		for (int i = 0; i < outputs.size(); i++) {
			System.out.println(outputs.get(i));
		}
	}

	static ArrayList<String> permute(char[] a, int x, int c, int k, ArrayList<String> outputs) {

		if (x == a.length) {
			String str = (" [");
			String strIn = "";
			String output = "";
			for (int i = 0; i < a.length; i++) {
				if (i % c != c - 1) {
					strIn += a[i];
				} else {
					strIn += a[i];
					char charArray[] = strIn.toCharArray();
					Arrays.sort(charArray);
					output += (str + new String(charArray) + "]");
					str = ("\t[");
					strIn = "";
					if ((i % (c * k)) == ((c * k) - 1)) {
						outputs.add(output);
					}
				}
			}

		} else {

			for (int i = x; i < a.length; i++) {
				char temp = a[x];
				a[x] = a[i];
				a[i] = temp;

				permute(a, x + 1, c, k, outputs);

				temp = a[x];
				a[x] = a[i];
				a[i] = temp;
			}
		}

		return outputs;
	}
}

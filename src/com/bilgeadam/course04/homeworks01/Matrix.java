package com.bilgeadam.course04.homeworks01;

import java.util.Scanner;

public class Matrix {
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to MATRIX!");
		readInput();
		scan.close();
		System.out.println("Bye...");
	}

	private static void readInput() {
		
		System.out.print("Enter the 'i' for A[i][j] : ");
		int row = scan.nextInt();
		System.out.print("Enter the 'j' for A[i][j] : ");
		int column = scan.nextInt();

		createMatrix(row, column);
	}

	private static void createMatrix(int row, int column) {
		int[][] inputMatrix = new int[row][column];

		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print("Enter [" + i + "][" + j + "] : ");
				inputMatrix[i][j] = scan.nextInt();
			}
		}
		printMatrix(inputMatrix);
		transposeMatrix(inputMatrix);
	}

	private static void printMatrix(int[][] inputMatrix) {
		System.out.println("---------------------------------------------");
		String str = "|\t";

		for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix[0].length; j++) {
				str += inputMatrix[i][j] + "\t";
			}
			System.out.println(str + "|");
			str = "|\t";
		}
	}

	private static void transposeMatrix(int[][] inputMatrix) {
		int[][] transposeMatrix = new int[inputMatrix[0].length][inputMatrix.length];

		for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix[0].length; j++) {
				transposeMatrix[j][i] = inputMatrix[i][j];
			}
		}
		printMatrix(transposeMatrix);
	}
}

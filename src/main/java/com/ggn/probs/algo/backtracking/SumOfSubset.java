package com.ggn.probs.algo.backtracking;

import java.util.Arrays;

public class SumOfSubset {
	static int SIZE = 3;
	static int[] W = {1, 2, 1};
	static int TOTAL = 3;
	
	public static void printSolution(int[] solution) {
		for(int i = 0 ; i < SIZE ; i++) {
			System.out.print(solution[i] + " ");
		}
		System.out.println();
	}
	
	public static void sumOfSubsetSolution(int[] solution, int T, int R) {
		if(T == TOTAL) {
			System.out.println();
			printSolution(solution);
		} else {
			for(int i = R; i < SIZE; i++) {
				if(isValid(T,i)) {
					solution[i] = 1;
					sumOfSubsetSolution(solution, T + W[i], i + 1);
					solution[i] = 0;
				}
			}
		}
	}

	private static boolean isValid(int T, int R) {
		if(T + W[R] <= TOTAL)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int[] solution = new int[SIZE];
		
		Arrays.fill(solution, 0);
		
//		printSolution(solution);
		
		sumOfSubsetSolution(solution, 0, 0);
	}

}

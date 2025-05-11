package com.ggn.probs.algo.fixedsize.slidingwindow;

public class MaxSumAllSubArraysOfSizeK {

	public void maxSumAllSubArraysOfSizeK(int[] A, int K) {
		int n = A.length;
		int sum = 0;
		int MAX = Integer.MIN_VALUE;

		int i = 0;
		int j = 0;

		while (j < n) {
			if (j - i + 1 < K) {
				sum += A[j];
				j++;
			} else if (j - i + 1 == K) {
				sum += A[j];

				if (sum > MAX) {
					MAX = sum;
					System.out.print(" : " + MAX);
				}

				sum -= A[i];
				i++;
				j++;
			}
		}

		System.out.println("\nMax : " + MAX);
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int K = 3;

		MaxSumAllSubArraysOfSizeK op = new MaxSumAllSubArraysOfSizeK();
		op.maxSumAllSubArraysOfSizeK(A, K);
	}

}

package com.ggn.probs.algo.slidingwindow.fixed;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstNegInAllSubArrayOfSizeK {

	public void firstNeginAllSubArrayOfSizeK(int[] A, int K) {
		int n = A.length;

		int i = 0;
		int j = 0;
		Deque<Integer> q = new ArrayDeque<Integer>();

		while (j < n) {
			if (j - i + 1 < K) {
				if (A[j] < 0) {
					q.offerLast(A[j]);
				}

				j++;
			} else if (j - i + 1 == K) {
				if (A[j] < 0) {
					q.offerLast(A[j]);
				}

				if (!q.isEmpty())
					System.out.print(" " + q.peekFirst());
				else
					System.out.print(" " + "0");

				if (!q.isEmpty() && q.peekFirst() == A[i]) {
					q.pollFirst();
				}

				i++;
				j++;

			}
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int K = 3;

		FirstNegInAllSubArrayOfSizeK op = new FirstNegInAllSubArrayOfSizeK();
		op.firstNeginAllSubArrayOfSizeK(A, K);
	}

}

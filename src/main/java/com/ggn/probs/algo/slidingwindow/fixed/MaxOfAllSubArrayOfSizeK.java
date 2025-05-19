package com.ggn.probs.algo.slidingwindow.fixed;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxOfAllSubArrayOfSizeK {

	public void maxOfAllSubArrayOfSizeK(int[] A, int K) {
		int n = A.length;
		Deque<Integer> deque = new ArrayDeque<Integer>();

		int i = 0;
		int j = 0;

		while (j < n) {
			if (j - i + 1 < K) {
				while (!deque.isEmpty() && deque.peekLast() < A[j]) {
					deque.pollLast();
				}

				deque.offerLast(A[j]);
				j++;

			} else if (j - i + 1 == K) {
				while (!deque.isEmpty() && deque.peekLast() < A[j]) {
					deque.pollLast();
				}

				deque.offerLast(A[j]);

				System.out.print(" " + deque.peekFirst());

				if (!deque.isEmpty() && (A[i] == deque.peekFirst())) {
					deque.pollFirst();
				}

				i++;
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int K = 3;

		MaxOfAllSubArrayOfSizeK op = new MaxOfAllSubArrayOfSizeK();
		op.maxOfAllSubArrayOfSizeK(A, K);

	}

}

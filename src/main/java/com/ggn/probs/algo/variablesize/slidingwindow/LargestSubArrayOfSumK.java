package com.ggn.probs.algo.variablesize.slidingwindow;

public class LargestSubArrayOfSumK {

	public int largestSubArrayOfSumK(int[] A, int K) {
		int i = 0;
		int j = 0;
		int n = A.length;
		int s = 0;
		int mx = Integer.MIN_VALUE;

		while (j < n) {
			s = s + A[j];

			if (s < K) {
				j++;
			} else if (s == K) {
				
				System.out.println("i : " + i + ", j : " + j);
				mx = Math.max(j - i + 1, mx);
				j++;
			} else if (s > K) {
				while (s > K) {
					s = s - A[i];
					i++;
				}
				
				if(s == K) {
					System.out.println("i : " + i + ", j : " + j);
					mx = Math.max(j - i + 1, mx);
				}

				j++;
			}
		}

		return mx;
	}

	public static void main(String[] args) {
		LargestSubArrayOfSumK op = new LargestSubArrayOfSumK();
		int[] A = { 4, 1, 1, 1, 2, 3, 5 };
		
		System.out.println("Max : " + op.largestSubArrayOfSumK(A, 5));
	}

}

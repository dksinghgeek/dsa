package com.ggn.probs.company.mpokket;

public class SumOfSubArray {

	public static void sumOfSubArrayImpl(int[] arr, int k) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int n = arr.length;

		while (j < n) {
			if (j - i + 1 < k) {
				sum += arr[j];
				j++;
			} else if (j - i + 1 == k) {
				sum += arr[j];
				System.out.print(" " + sum);
				sum -=arr[i];
				i++;
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr =  {1, -2, 3, -4, 5, 6};
		int K = 2;

		sumOfSubArrayImpl(arr, K);
		
		
	}

}

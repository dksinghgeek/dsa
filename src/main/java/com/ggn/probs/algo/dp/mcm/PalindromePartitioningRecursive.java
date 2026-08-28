package com.ggn.probs.algo.dp.mcm;

public class PalindromePartitioningRecursive {
	public int solve(char[] ch, int i, int j) {
		if (i >= j)
			return 0;

		if (isPalindrome(ch, i, j))
			return 0;

		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = solve(ch, i, k) + solve(ch, k + 1, j) + 1;

			if (temp < min)
				min = temp;
		}

		return min;
	}

	public boolean isPalindrome(char[] ch, int i, int j) {
		if (ch.length == 0)
			return false;

		if (ch.length == 1)
			return true;

		while (i <= j) {
			if (ch[i] != ch[j])
				return false;

			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromePartitioningRecursive op = new PalindromePartitioningRecursive();
		char[] ch = { 'n', 'i', 't', 'i', 'k' };

		if (op.isPalindrome(ch, 0, ch.length - 1)) {
			System.out.println("Yes");
		} else {
			System.out.println("no");
		}

		System.out.println(op.solve(ch, 0, ch.length - 1));
	}

}

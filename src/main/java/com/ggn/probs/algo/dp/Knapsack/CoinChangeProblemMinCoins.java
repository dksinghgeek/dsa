package com.ggn.probs.algo.dp.Knapsack;

public class CoinChangeProblemMinCoins {

	public int solve(int[] coins, int sum) {
		int[][] t = new int[coins.length + 1][sum + 1];

		for (int i = 0; i < coins.length + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (j == 0) {
					t[i][j] = 0;
				}

				if (i == 0) {
					t[i][j] = Integer.MAX_VALUE - 1;
				}
			}
		}

		for (int j = 1; j < sum + 1; j++) {
			if (j % coins[1] == 0) {
				t[1][j] = j / coins[1];
			} else {
				t[1][j] = Integer.MAX_VALUE - 1;
			}
		}

		for (int i = 2; i < coins.length + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (coins[i-1] <= j) {
					t[i][j] = Math.min(1 + t[i][j - coins[i - 1]], t[i - 1][j]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[coins.length][sum];
	}

	public static void main(String[] args) {
		CoinChangeProblemMinCoins op = new CoinChangeProblemMinCoins();
		int[] coins = { 1, 2, 3 };
		int sum = 5;
		
		System.out.println(op.solve(coins, sum));
	}

}

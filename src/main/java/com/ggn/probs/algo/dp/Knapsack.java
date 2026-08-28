package com.ggn.probs.algo.dp;


import com.ggn.probs.algo.greedy.Kanpsack;

//o-1
public class Knapsack {
    private int[][] t;

    public Knapsack() {

    }

    public Knapsack(int n, int W) {
        this.t = new int[n + 1][W + 1];
    }

    public int kanpsackAlgoMemoization(int[] P, int[] wt, int W, int n) {
        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] < W) {
            return Math.max(P[n - 1] + kanpsackAlgoMemoization(P, wt, W - wt[n - 1], n - 1), kanpsackAlgoMemoization(P, wt, W, n - 1));
        } else {
            return kanpsackAlgoMemoization(P, wt, W, n - 1);
        }
    }

    public int knapsackTopDown(int[] P, int[] wt, int W, int n) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) {
                    this.t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] < j) {
                    t[i][j] = Math.max(P[i - 1] + t[i - 1][j - wt[i - 1]], t[n - 1][j - wt[i - 1]]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][W];
    }


    public static void main(String[] args) {
        int[] P = {0, 1, 2, 5, 6};
        int[] wt = {0, 2, 3, 4, 5};

        Knapsack op = new Knapsack();

        System.out.println(op.kanpsackAlgoMemoization(P, wt, 8, 5));

        int[] p = {1, 2, 5, 6};
        int[] w = {2, 3, 4, 5};
        op = new Knapsack(4, 8);
        System.out.println(op.knapsackTopDown(p, w, 8, 4));
    }

}

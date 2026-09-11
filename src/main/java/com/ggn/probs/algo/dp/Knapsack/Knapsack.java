package com.ggn.probs.algo.dp.Knapsack;

//o-1
public class Knapsack {
    private int[][] t;

    public Knapsack() {

    }

    public Knapsack(int n, int W, int v) {
        this.t = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) {
                    this.t[i][j] = v;
                }
            }
        }
    }

    public int knapsackMemoization(int[] p, int[] wt, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (t[n][W] != 0)
            return t[n][W];

        if (wt[n - 1] <= W) {
            t[n][W] = Math.max(p[n - 1] + knapsackMemoization(p, wt, W - wt[n - 1], n - 1), knapsackMemoization(p, wt, W, n - 1));
            return t[n][W];
        } else {
            t[n][W] = knapsackMemoization(p, wt, W, n - 1);
            return t[n][W];
        }
    }

    public int knapsackAlgoRecursion(int[] P, int[] wt, int W, int n) {
        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] <= W) {
            return Math.max(P[n - 1] + knapsackAlgoRecursion(P, wt, W - wt[n - 1], n - 1), knapsackAlgoRecursion(P, wt, W, n - 1));
        } else {
            return knapsackAlgoRecursion(P, wt, W, n - 1);
        }
    }

    public int knapsackTopDown(int[] P, int[] wt, int W, int n) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    t[i][j] = Math.max(P[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
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

        System.out.println(op.knapsackAlgoRecursion(P, wt, 8, 5));

        int[] p = {1, 2, 5, 6};
        int[] w = {2, 3, 4, 5};
        op = new Knapsack(4, 8, 0);
        System.out.println(op.knapsackTopDown(p, w, 8, 4));

        int[] l = {1, 2, 5, 6};
        int[] m = {2, 3, 4, 5};
        op = new Knapsack(4, 8, 0);
        System.out.println(op.knapsackMemoization(l, m, 8, 4));
    }

}

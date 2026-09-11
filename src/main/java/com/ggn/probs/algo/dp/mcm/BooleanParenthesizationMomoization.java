package com.ggn.probs.algo.dp.mcm;

public class BooleanParenthesizationMomoization {
    static int[][][] t;

    public int countWays(char[] A) {
        int n = A.length;
        t = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j][0] = -1;
                t[i][j][1] = -1;
            }
        }

        return solve(A, 0, n - 1, 1);
    }

    public int solve(char[] A, int i, int j, int isTrue) {
        if (i > j) return 0;

        if (i == j) {
            if (isTrue == 1) {
                return A[i] == 'T' ? 1 : 0;
            } else {
                return A[i] == 'F' ? 1 : 0;
            }
        }

        if(t[i][j][isTrue] != -1){
            return t[i][j][isTrue];
        }

        int ans = 0;
        for (int k = i + 1; k <= j - 1; k = k + 2) {
            int lT = solve(A, i, k - 1, 1);
            int lF = solve(A, i, k - 1, 0);
            int rT = solve(A, k + 1, j, 1);
            int rF = solve(A, k + 1, j, 0);

            if (A[k] == '&') {
                if (isTrue == 1) {
                    ans += lT * rT;
                } else {
                    ans += lF * rT + lT * rF + lF * rF;
                }
            } else if (A[k] == '|') {
                if (isTrue == 1) {
                    ans += lT * rT + lT * rF + lF * rT;
                } else {
                    ans += lF * rF;
                }
            } else if (A[k] == '^') {
                if (isTrue == 1) {
                    ans += lT * rF + lF * rT;
                } else {
                    ans += lT * rT + lF * rF;
                }
            }
        }

        return t[i][j][isTrue] = ans;
    }

    public static void main(String[] args) {
        BooleanParenthesizationMomoization op = new BooleanParenthesizationMomoization();
        char[] A = {'T', '|', 'F', '&', 'T'};

        System.out.println(op.countWays(A));
    }
}

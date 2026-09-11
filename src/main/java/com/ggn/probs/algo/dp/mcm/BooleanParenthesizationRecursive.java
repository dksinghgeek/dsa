package com.ggn.probs.algo.dp.mcm;

public class BooleanParenthesizationRecursive {
    public int solve(char[] A, int i, int j, Character isTrue) {
        if (i > j) return 0;

        if (i == j) {
            if (isTrue.equals('T')) {
                return (A[i] == 'T') ? 1 : 0;
            } else {
                return (A[i] == 'F') ? 1 : 0;
            }
        }
        int ans = 0;
        for (int k = i + 1; k <= j - 1; k = k + 2) {
            int lT = solve(A, i, k - 1, 'T');
            int lF = solve(A, i, k - 1, 'F');
            int rT = solve(A, k + 1, j, 'T');
            int rF = solve(A, k + 1, j, 'F');

            if (A[k] == '&') {
                if (isTrue == 'T') {
                    ans += lT * rT;
                } else {
                    ans += lF * rT + lT * rF + lF * rF;
                }
            } else if (A[k] == '|') {
                if (isTrue == 'T') {
                    ans += lT * rT + lT * rF + lF * rT;
                } else {
                    ans += lF * rF;
                }
            } else if (A[k] == '^') {
                if (isTrue == 'T') {
                    ans += lF * rF + lF * rT;
                } else {
                    ans += lT * rT + lF * rF;
                }
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        BooleanParenthesizationRecursive op = new BooleanParenthesizationRecursive();
        char[] A = {'T', '|', 'F', '&', 'T'};

        System.out.println(op.solve(A, 0, A.length - 1, 'T'));
    }
}

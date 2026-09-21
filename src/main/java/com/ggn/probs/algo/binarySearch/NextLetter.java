package com.ggn.probs.algo.binarySearch;

public class NextLetter {
    public char solve(char[] A, char c) {
        int[] x = new int[A.length];

        int res = -1;
        for (int k = 0; k < A.length; k++) {
            x[k] = A[k] - 'a';
        }

        int i = 0;
        int j = A.length - 1;

        int y = c - 'a';

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (y >= x[mid]) {
                i = mid + 1;
            } else {
                res = mid;
                j = mid - 1;
            }
        }

        return (char) (x[res] + 'a');
    }

    public static void main(String[] agrs) {
        NextLetter op = new NextLetter();
        char[] A = {'a', 'e', 'f', 'h'};
        System.out.println(op.solve(A, 'f'));
    }
}

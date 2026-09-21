package com.ggn.probs.algo.binarySearch;

public class LastOccurrence {
    public int solve(int[] A, int k) {
        int i = 0;
        int j = A.length - 1;

        int res = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (k == A[mid]) {
                res = mid;
                i = mid + 1;
            } else if (k < A[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LastOccurrence op = new LastOccurrence();

        int[] A = {1, 2, 3, 4, 4, 4, 6, 7, 8};
        System.out.println(op.solve(A, 4));
    }
}

package com.ggn.probs.algo.binarySearch;

public class PeakElement {
    public int solve(int[] A) {
        int i = 0;
        int j = A.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (mid > 0 && mid < A.length - 1) {
                if ((A[mid] > A[mid - 1]) && (A[mid] > A[mid + 1])) {
                    return mid;
                } else if (A[mid + 1] > A[mid]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else if (mid == 0) {
                if (A[0] > A[1]) {
                    return 0;
                } else {
                    return 1;
                }
            } else if (mid == A.length - 1) {
                if (A[A.length - 1] > A[A.length - 2]) {
                    return A.length - 1;
                } else {
                    return A.length - 2;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        PeakElement op = new PeakElement();
        int[] A = {1, 3, 6, 9, 10, 7, 5, 2};

        System.out.println(op.solve(A));
    }
}

package com.ggn.probs.algo.binarySearch;

public class NumberOfTimeArrayIsRotated {
    public int solve(int[] A) {
        int i = 0;
        int j = A.length - 1;
        int n = A.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            int next = (mid + 1) % 2;
            int prev = (mid + n - 1) % 2;
            if (A[mid] < A[prev] && A[mid] < A[next]) {
                return mid;
            } else if (A[i] <= A[mid]) {
                i = mid;
            } else {
                j = mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        NumberOfTimeArrayIsRotated op = new NumberOfTimeArrayIsRotated();
        int[] A = {4, 5, 6, 7, 1, 2, 3};

        System.out.println(op.solve(A));
    }
}

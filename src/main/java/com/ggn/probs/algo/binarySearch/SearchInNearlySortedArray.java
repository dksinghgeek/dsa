package com.ggn.probs.algo.binarySearch;

public class SearchInNearlySortedArray {
    public int solve(int[] A, int k) {
        int i = 0;
        int j = A.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (A[mid] == k) {
                return mid;
            } else if (mid - 1 >= 0 && A[mid - 1] == k) {
                return mid - 1;
            } else if (mid + 1 <= A.length - 1 && A[mid + 1] == k) {
                return mid + 1;
            } else if (k < A[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInNearlySortedArray op = new SearchInNearlySortedArray();
        int[] A = {4, 5, 6, 7, 9, 10};

        System.out.println(op.solve(A, 9));
    }
}

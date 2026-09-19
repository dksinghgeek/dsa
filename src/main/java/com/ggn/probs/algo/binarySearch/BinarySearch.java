package com.ggn.probs.algo.binarySearch;

public class BinarySearch {
    public int binarySearch(int[] A, int k) {
        int i = 0;
        int j = A.length;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (A[mid] == k) {
                return mid;
            } else if (k < A[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch op = new BinarySearch();

        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(op.binarySearch(A, 6));
    }
}

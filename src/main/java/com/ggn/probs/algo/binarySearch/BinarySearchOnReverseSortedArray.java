package com.ggn.probs.algo.binarySearch;

public class BinarySearchOnReverseSortedArray {
    public int binarySearch(int[] A, int k) {
        int i = 0;
        int j = A.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (A[mid] == k) {
                return mid;
            } else if (k < A[i]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearchOnReverseSortedArray op = new BinarySearchOnReverseSortedArray();

        int[] A = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(op.binarySearch(A, 3));
    }
}

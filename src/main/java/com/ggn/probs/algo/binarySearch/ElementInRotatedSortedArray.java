package com.ggn.probs.algo.binarySearch;

public class ElementInRotatedSortedArray {
    public int solve(int[] A, int k) {
        NumberOfTimeArrayIsRotated op1 = new NumberOfTimeArrayIsRotated();
        int index = op1.solve(A);

        if (binarySearch(A, 0, index - 1, k) != -1) {
            return binarySearch(A, 0, index - 1, k);
        } else {
            return binarySearch(A, index, A.length - 1, k);
        }
    }

    public int binarySearch(int[] A, int i, int j, int k) {
        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (k == A[mid]) {
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
        ElementInRotatedSortedArray op = new ElementInRotatedSortedArray();
        int[] A = {4, 5, 6, 7, 1, 2, 3};

        System.out.println(op.solve(A, 4));
    }
}

package com.ggn.probs.algo.binarySearch;

public class FindFloorOfElementInSortedArray {
    public int solve(int[] A, int k) {
        int i = 0;
        int j = A.length - 1;
        int res = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (A[mid] == k) {
                return mid;
            } else if (k > A[mid]) {
                res = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FindFloorOfElementInSortedArray op = new FindFloorOfElementInSortedArray();
        int[] A = {4, 5, 6, 7, 9, 10};

        System.out.println(op.solve(A, 8));
    }
}

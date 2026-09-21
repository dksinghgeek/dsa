package com.ggn.probs.algo.binarySearch;

public class FindCeilingOfElementInSortedArray {
    public int solve(int[] A, int k) {
        int i = 0;
        int j = A.length - 1;
        int res = -1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (A[mid] == k) {
                return mid;
            } else if (k > A[mid]) {
                i = mid + 1;
            } else {
                res = mid;
                j = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FindCeilingOfElementInSortedArray op = new FindCeilingOfElementInSortedArray();
        int[] A = {4, 5, 6, 7, 9, 10};

        System.out.println(op.solve(A, 8));
    }
}

package com.ggn.probs.algo.binarySearch;

public class OrderNotKnownSearch {

    public int solve(int[] A, int k) {
        if (A.length == 1 && A[0] == k) return 0;

        if (A.length == 1) return -1;

        boolean isAsc = A[1] > A[0];

        int i = 0;
        int j = A.length - 1;
        if (isAsc) {
            while (i <= j) {
                int mid = i + (j - 1) / 2;

                if (k == A[mid]) {
                    return mid;
                } else if (k < A[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        } else {
            while (i <= j) {
                int mid = i + (j - i) / 2;

                if (k == A[mid]) {
                    return mid;
                } else if (k < A[mid]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        OrderNotKnownSearch op = new OrderNotKnownSearch();
//        int[] A = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(op.solve(A, 3));
    }
}

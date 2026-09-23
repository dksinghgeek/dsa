package com.ggn.probs.algo.binarySearch;

public class SearchInSortedRowNColumn {
    public void solve(int[][] A, int k) {
        int i = 0;
        int j = A[0].length - 1;
        while ((i >= 0 && i < A.length) && (j >= 0 && j < A[0].length)) {
            if (A[i][j] == k) {
                System.out.println("(i,j)" + "(" + i + "," + j + ")");
                break;
            } else if (k < A[i][j]) {
                j--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        SearchInSortedRowNColumn op = new SearchInSortedRowNColumn();

        int[][] A = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        op.solve(A, 13);
    }
}

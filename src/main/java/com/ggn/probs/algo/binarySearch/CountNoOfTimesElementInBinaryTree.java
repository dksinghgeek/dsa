package com.ggn.probs.algo.binarySearch;

public class CountNoOfTimesElementInBinaryTree {
    public int startIndexOfElement(int[] A, int x) {
        int i = 0;
        int j = A.length - 1;

        int res = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (A[mid] == x) {
                res = mid;
                j = mid - 1;
            } else if (x < A[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return res;
    }

    public int endIndexOfElement(int[] A, int x) {
        int i = 0;
        int j = A.length - 1;

        int res = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (A[mid] == x) {
                res = mid;
                i = mid + 1;
            } else if (x < A[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args){
        CountNoOfTimesElementInBinaryTree op = new CountNoOfTimesElementInBinaryTree();
        int[] A= {1,2,3,3,3,3,4,5,6};

        int c = op.endIndexOfElement(A,3) - op.startIndexOfElement(A,3) + 1;

        System.out.println(c);
    }
}

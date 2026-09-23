package com.ggn.probs.algo.binarySearch;

public class FindMaxInBiotonicArray {
    public int solve(int[] A) {
        int i = 0;
        int j = A.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (mid > 0 && mid < A.length - 1) {
                if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                    return mid;
                } else if (A[mid + 1] > A[mid]) {
                    i = mid + 1;
                } else if (A[mid - 1] > A[mid]) {
                    j = mid - 1;
                }
            } else if (mid == 0) {
                if (A[0] > A[1]) {
                    return 0;
                } else {
                    return 1;
                }
            } else if (mid == A.length - 1) {
                if (A[A.length - 1] > A[A.length - 2]) {
                    return A.length - 1;
                } else {
                    return A.length - 2;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindMaxInBiotonicArray op = new FindMaxInBiotonicArray();
        int[] A = {1, 3, 6, 9, 10, 7, 5, 2};

        System.out.println(op.solve(A));

        int mid = op.solve(A);

        int f1 = op.binarySearchAsc(A,0,mid-1, 3);
        if(f1 != -1){
            System.out.println("ASC " + f1);
        } else{
            System.out.println("DESC " + op.binarySearchDesc(A, mid, A.length-1, 3));
        }
    }

    public int binarySearchAsc(int[] A, int i, int j, int k) {
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

    public int binarySearchDesc(int[] A, int i, int j, int k) {
        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (k == A[mid]) {
                return mid;
            } else if (k > A[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}

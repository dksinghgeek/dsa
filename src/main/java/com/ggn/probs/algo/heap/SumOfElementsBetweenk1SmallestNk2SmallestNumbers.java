package com.ggn.probs.algo.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class SumOfElementsBetweenk1SmallestNk2SmallestNumbers {
    public int solve(int[] A, int k) {
        PriorityQueue<Integer> hp = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            hp.offer(A[i]);

            if (hp.size() > k) {
                hp.poll();
            }
        }

        return hp.peek();
    }

    public static void main(String[] args) {
        SumOfElementsBetweenk1SmallestNk2SmallestNumbers op = new SumOfElementsBetweenk1SmallestNk2SmallestNumbers();
        int[] A = {1, 3, 12, 5, 15, 11};
        int k1 = 3;
        int k2 = 6;

        int lower = op.solve(A, k1);
        int upper = op.solve(A, k2);

        int total = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > lower && A[i] < upper) {
                total += A[i];
            }
        }

        System.out.println(total);
    }
}

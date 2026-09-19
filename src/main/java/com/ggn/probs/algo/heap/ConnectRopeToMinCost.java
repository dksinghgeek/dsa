package com.ggn.probs.algo.heap;

import java.util.PriorityQueue;

public class ConnectRopeToMinCost {
    public int solve(int[] A) {
        PriorityQueue<Integer> hp = new PriorityQueue<>();

        for (int i = 0; i < A.length; i++) {
            hp.offer(A[i]);
        }

        int cost = 0;
        while (hp.size() >= 2) {
            int upper = hp.peek();
            hp.poll();

            int lower = hp.peek();
            hp.poll();

            cost += upper + lower;

            hp.offer(upper + lower);
        }

        return cost;
    }

    public static void main(String[] args) {
        ConnectRopeToMinCost op = new ConnectRopeToMinCost();
        int[] A = {1, 2, 3, 4, 5};

        System.out.println(op.solve(A));
    }
}

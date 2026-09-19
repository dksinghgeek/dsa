package com.ggn.probs.algo.heap;

import java.time.Instant;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequencyNumbers {

    public void solve(int[] A, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }

        PriorityQueue<Pair<Integer, Integer>> hp = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return Integer.compare(o1.getKey(), o2.getKey());
            }
        });

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            hp.offer(new Pair<>(entry.getValue(), entry.getKey()));

            if (hp.size() > k) {
                hp.poll();
            }
        }

        while (!hp.isEmpty()) {
            Pair<Integer, Integer> out = hp.peek();
            hp.poll();

            System.out.println("Data : " + out.getValue() + " Frequency : " + out.getKey());
        }

    }

    public static void main(String[] args) {
        TopKFrequencyNumbers op = new TopKFrequencyNumbers();
        int[] A = {1, 1, 1, 3, 2, 2, 4};
        int k = 2;

        op.solve(A, k);
    }
}

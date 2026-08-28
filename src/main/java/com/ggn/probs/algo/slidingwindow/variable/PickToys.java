package com.ggn.probs.algo.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

public class PickToys {

	public int pickToys(char[] A, int K) {
		int mx = Integer.MIN_VALUE;
		int i = 0;
		int j = 0;
		int n = A.length;
		Map<Character, Integer> m = new HashMap<>();
		int count = 0;

		while (j < n) {
			if (m.containsKey(A[j])) {
				m.put(A[j], m.get(A[j]) + 1);
				count++;
			} else {
				m.put(A[j], 1);
				count++;
			}

			if (m.size() < K) {
				j++;
			} else if (m.size() == K) {
				mx = Math.max(mx, count);
				j++;
			} else if (m.size() > K) {
				while (m.size() > K) {
					int val = m.get(A[i]) - 1;
					if (val == 0) {
						m.remove(A[i]);
					} else {
						m.put(A[i], val);
					}
					i++;
					count--;
				}

				if (m.size() == K) {
					mx = Math.max(mx, count);
				}

				j++;
			}
		}

		return mx;
	}

	public static void main(String[] args) {
		PickToys op = new PickToys();
		char[] A = { 'p', 'w', 'w', 'w', 'k', 'e', 'w' };

		System.out.println(op.pickToys(A, 2));
	}

}

package com.ggn.probs.algo.variablesize.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public int minimumWindowSubstring(char[] A, char[] B) {
		int output = 0;
		int i = 0;
		int j = 0;
		int n = A.length;
		Map<Character, Integer> m = processPattern(B);
		int count = m.size();

		while (j < n) {
			if (m.containsKey(A[j])) {
				int val = m.get(A[j]) - 1;
				m.put(A[j], val);

				if (val == 0) {
					count--;
				}
			}

			if (count == 0) {
				output++;

				while (count == 0) {
					if (m.containsKey(A[i])) {
						int val = m.get(A[i]) + 1;
						m.put(A[i], val);

						if (val == 1) {
							count++;
						}

						if (count == 0) {
							output++;
						}
					}
					
					i++;
				}
				j++;

			} else {
				j++;
			}

		}

		return output;
	}

	private Map<Character, Integer> processPattern(char[] B) {
		Map<Character, Integer> m = new HashMap<>();

		for (int i = 0; i < B.length; i++) {
			if (m.containsKey(B[i])) {
				m.put(B[i], m.get(B[i]) + 1);
			} else {
				m.put(B[i], 1);
			}
		}

		return m;
	}

	public static void main(String[] args) {
		MinimumWindowSubstring op = new MinimumWindowSubstring();
		char[] A = { 'T', 'O', 'T', 'M', 'T', 'A', 'P', 'T', 'A', 'T' };
		char[] B = { 'T', 'T', 'A' };

		System.out.println(op.minimumWindowSubstring(A, B));
	}

}

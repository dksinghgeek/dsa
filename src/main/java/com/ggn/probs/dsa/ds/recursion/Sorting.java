package com.ggn.probs.dsa.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class Sorting {

	public List<Integer> sort(List<Integer> A, int n) {
		if (n == 1)
			return A;

		int temp = A.remove(n - 1);
		A = sort(A, n - 1);
		A = insert(A, temp, n - 1);

		return A;
	}

	private List<Integer> insert(List<Integer> A, int temp, int n) {
		if (A.size() == 0 || A.get(n - 1) < temp) {
			A.add(temp);
			return A;
		}

		int val = A.remove(n - 1);

		A = insert(A, temp, n - 1);

		A.add(val);

		return A;

	}

	public static void main(String[] args) {
		Sorting op = new Sorting();

		List<Integer> A = new ArrayList<>(List.of(2, 7, 1, 4, 11, 3, 5));

		A = op.sort(A, A.size());

		A.forEach(a -> System.out.print(" " + a.intValue()));
	}

}

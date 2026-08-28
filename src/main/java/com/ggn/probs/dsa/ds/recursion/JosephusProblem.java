package com.ggn.probs.dsa.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

	public static void main(String[] args) {
		JosephusProblem ob = new JosephusProblem();
		int N = 40;
		int K = 7;

		List<Integer> locations = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			locations.add(i + 1);
		}

		K = K - 1;
		int index = 0;
		ob.solve(index, K, locations);
	}

	private void solve(int index, int k, List<Integer> locations) {
		if (locations.size() == 1) {
			System.out.println(locations.get(0));
			return;
		}

		index = (index + k) % locations.size();
		locations.remove(index);
		solve(index, k, locations);

	}
}

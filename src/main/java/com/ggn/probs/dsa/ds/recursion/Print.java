package com.ggn.probs.dsa.ds.recursion;

public class Print {

	public void printForward(int n) {
		if (n == 1) {
			System.out.print(" " + n);
			return;
		} else {
			printForward(n - 1);
			System.out.print(" " + n);
		}
	}

	public void printBackward(int n) {
		if (n == 1) {
			System.out.print(" " + n);
		} else {
			System.out.print(" " + n);
			printBackward(n - 1);
		}
	}

	public int kthSymbolInGrammer(int N, int K) {
		if (N == 1 && K == 1) {
			return 0;
		}

		int mid = (int) (Math.pow(2, N - 1) / 2);

		if (K <= mid) {
			return kthSymbolInGrammer(N - 1, K);
		} else {
			return kthSymbolInGrammer(N - 1, K - mid) == 0 ? 1 : 0;
		}
	}

	public static void main(String[] args) {
		Print op = new Print();
//		op.printForward(7);

		System.out.println();

//		op.printBackward(7);

		System.out.println(op.kthSymbolInGrammer(2, 2));

	}

}

package com.ggn.probs.dsa.ds.string;

public class StringOps {

	public void duplicateInStringsUsingBitswise(String input) {
		int H = 0;
		int X = 0;

		for (int i = 0; i < input.length(); i++) {
			X = 1;
			X = X << input.charAt(i) - 'a';

			if ((H & X) > 0) {
				System.out.println("Duplicate : " + input.charAt(i));
			} else {
				H = H | X;
			}
		}
	}

	public int myAtoi(String s) {
		if (s.length() == 0)
			return 0;

		int i = 0;

		while (s.charAt(i) == ' ' && i < s.length()) {
			i++;
		}

		int signed = 1;
		if (s.charAt(i) == '-') {
			signed = -1;
			i++;
		}

		while (s.charAt(i) == '0') {
			i++;
		}

		long out = 0;
		while (i < s.length()) {
			if (!isDigit(s.charAt(i)))
				break;

			out = out * 10 + s.charAt(i++) - '0';

			if (out * signed < Integer.MIN_VALUE) {
				return (int)Integer.MIN_VALUE;
			} else if (out * signed > Integer.MAX_VALUE) {
				return (int)Integer.MAX_VALUE;
			}
		}
		
		return (int)out * signed;
	}

	private boolean isDigit(char ch) {
		return ch - '0' >= 0 && ch - '0' <= 9 ? true : false;
	}

	public static void main(String[] args) {
		String input = "findings";
		StringOps op = new StringOps();
//      op.duplicateInStringsUsingBitswise(input);

		System.out.println(op.myAtoi("-91283472332"));
	}

}

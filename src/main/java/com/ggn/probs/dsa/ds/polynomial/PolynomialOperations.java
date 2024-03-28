package com.ggn.probs.dsa.ds.polynomial;

public class PolynomialOperations {
	public Polynomial create(int[][] matrix, int n) {
		Polynomial polynomial = new Polynomial(n);
		for (int i = 0; i < n; i++) {
			Term term = new Term(matrix[0][i], matrix[1][i]);
			polynomial.getTerms()[i] = term;
		}

		return polynomial;
	}

	public Polynomial add(Polynomial p1, Polynomial p2) {
		Polynomial s = new Polynomial(p1.getSize() + p2.getSize());
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < p1.getSize() && j < p2.getSize()) {
			if (p1.terms[i].getExp() < p2.terms[j].getExp()) {
				s.getTerms()[k++] = p1.terms[i++];
			} else if (p2.terms[j].getExp() < p1.terms[i].getExp()) {
				s.getTerms()[k++] = p2.terms[j++];
			} else {
				Term t = new Term(p1.terms[i].getCo() + p2.terms[j].getCo(), p1.terms[i].getExp());
				s.getTerms()[k++] = t;
				i++;
				j++;
			}
		}

		for (; i < p1.getSize(); i++) {
			s.getTerms()[k++] = p1.getTerms()[i];
		}

		for (; j < p2.getSize(); j++) {
			s.getTerms()[k++] = p2.getTerms()[j];
		}
		
		s.n = k;
		return s;
	}

	public void display(Polynomial polynomial) {
		for (int i = 0; i < polynomial.n; i++) {
			System.out.print(polynomial.terms[i].getCo() + "X" + polynomial.terms[i].getExp() + " + ");
		}
	}

	private int power(int x, int n) {
		if (n == 0)
			return 1;
		else if (n % 2 == 0) {
			return power(x, n / 2) * power(x, n / 2);
		} else {
			return x * power(x, (n - 1) / 2) * power(x, (n - 1) / 2);
		}
	}

	public static void main(String[] args) {
		PolynomialOperations poly = new PolynomialOperations();
		int[][] m1 = { { 2, 1, 4 }, { 1, 2, 3 } };
		int[][] m2 = { { 2, 1, 4 }, { 1, 3, 4 } };

		Polynomial p1 = poly.create(m1, 3);
		poly.display(p1);
		System.out.println();
		Polynomial p2 = poly.create(m2, 3);
		poly.display(p2);

		System.out.println();
		Polynomial s = poly.add(p1, p2);
		poly.display(s);

	}

	class Term {
		private int co;
		private int exp;

		public Term(int co, int val) {
			this.co = co;
			this.exp = val;
		}

		public int getCo() {
			return co;
		}

		public int getExp() {
			return exp;
		}
	}

	class Polynomial {
		private int n;
		private Term[] terms;

		public Polynomial(int n) {
			this.n = n;
			this.terms = new Term[n];
		}

		public int getSize() {
			return n;
		}

		public Term[] getTerms() {
			return terms;
		}
	}

}

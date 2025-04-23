package com.ggn.probs.dsa.ds.sparse;

public class Ploynomial {
	public Poly add(Poly p1, Poly p2) {
		Poly p3 = new Poly();
		p3.n = p1.n + p2.n;
		p3.terms = new Term[p1.n + p2.n];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < p1.n && j < p2.n) {
			if (p1.terms[i].exponent < p2.terms[j].exponent) {
				p3.terms[k++] = p1.terms[i++];
			} else if (p2.terms[j].exponent < p1.terms[i].exponent) {
				p3.terms[k++] = p2.terms[j++];
			} else {
				Term t = new Term();
				t.exponent = p2.terms[j].exponent;
				t.coefficient = p1.terms[i++].coefficient + p2.terms[j++].coefficient;
				p3.terms[k++] = t;
			}
		}

		for (; i < p1.n; i++) {
			p3.terms[k++] = p1.terms[i];
		}

		for (; j < p2.n; j++) {
			p3.terms[k++] = p2.terms[j];
		}

		return p3;
	}

	public void display(Poly p) {
		for (int i = 0; i < p.n; i++) {
			if (p.terms[i] != null) {
				System.out.print(p.terms[i].coefficient + "X" + p.terms[i].exponent + " + ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Ploynomial op = new Ploynomial();

		Poly p1 = new Poly();
		p1.n = 3;
		p1.terms = new Term[3];

		Term t1 = new Term();
		t1.coefficient = 1;
		t1.exponent = 1;

		Term t2 = new Term();
		t2.coefficient = 2;
		t2.exponent = 2;

		Term t3 = new Term();
		t3.coefficient = 3;
		t3.exponent = 3;

		Term[] terms = new Term[p1.n];
		terms[0] = t1;
		terms[1] = t2;
		terms[2] = t3;

		p1.terms = terms;

		op.display(p1);

		Poly p2 = new Poly();
		p2.n = 4;
		p2.terms = new Term[4];

		Term t11 = new Term();
		t11.coefficient = 1;
		t11.exponent = 1;

		Term t22 = new Term();
		t22.coefficient = 2;
		t22.exponent = 2;

		Term t33 = new Term();
		t33.coefficient = 3;
		t33.exponent = 3;
		
		Term t44 = new Term();
		t44.coefficient = 4;
		t44.exponent = 4;

		terms = new Term[p2.n];
		terms[0] = t11;
		terms[1] = t22;
		terms[2] = t33;
		terms[3] = t44;

		p2.terms = terms;

		op.display(p2);

		Poly p3 = op.add(p1, p2);

		op.display(p3);
	}

}

class Poly {
	int n;
	Term[] terms;
}

class Term {
	int coefficient;;
	int exponent;
}

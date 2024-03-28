package com.ggn.probs.dsa.ds.sparse;

public class SparseMatrixOperations {

	public Sparse create(int[][] matrix, int m, int n, int nonZero) {
		Sparse sparse = new Sparse(m, n, nonZero);
		int k = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] != 0) {
					Element element = new Element();
					element.i = i;
					element.j = j;
					element.val = matrix[i][j];
					sparse.elements[k++] = element;
				}
			}
		}
		sparse.nonZero = k;
		return sparse;
	}

	public Sparse add (Sparse s1, Sparse s2) {
		Sparse s = new Sparse(s1.m, s1.n, s1.nonZero + s2.nonZero);
		int i = 0; int j = 0; int k = 0;
		
		while(i < s1.nonZero && j < s2.nonZero) {
			if(s1.elements[i].i < s2.elements[j].i) {
				s.elements[k++] = s1.elements[i++];
			}else if(s1.elements[i].i > s2.elements[j].i) {
				s.elements[k++] = s2.elements[j++];
			}else {
				if(s1.elements[i].j < s2.elements[j].j) {
					s.elements[k++] = s1.elements[i++];
				}else if(s1.elements[i].j > s2.elements[j].j) {
					s.elements[k++] = s2.elements[j++];
				} else {
					Element element = new Element();
					element.i = s1.elements[i].i;
					element.j = s1.elements[i].j;;
					element.val = s1.elements[i++].val + s2.elements[j++].val;
					s.elements[k++] = element;
				}
			}
		}
		
		for(; i < s1.nonZero ; i++) {
			s.elements[k++] = s1.elements[i];
		}
		
		for(; j < s2.nonZero ; j++) {
			s.elements[k++] = s2.elements[j];
		}
		
		s.nonZero = k;
		return s;
	}
	
	public void display(Sparse s) {
		int k = 0;
		for (int i = 0; i < s.m; i++) {
			for (int j = 0; j < s.n; j++) {
				if (k < s.nonZero && i == s.elements[k].i && j == s.elements[k].j) {
					System.out.print(" " + s.elements[k++].val);
				} else {
					System.out.print(" 0");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		SparseMatrixOperations sp = new SparseMatrixOperations();
		int[][] m1 = { { 1, 0, 0, 1, 0 }, { 0, 2, 0, 0, 0 }, { 4, 0, 2, 0, 0 }, { 1, 0, 0, 0, 0 } };

		Sparse s1 = sp.create(m1, 4, 5, 6);
		sp.display(s1);
		
		System.out.println();

		int[][] m2 = { { 0, 0, 1, 0, 0 }, { 0, 4, 0, 0, 1 }, { 0, 0, 1, 0, 0 }, { 4, 0, 0, 0, 0 } };

		Sparse s2 = sp.create(m2, 4, 5, 5);
		sp.display(s2);
		
		System.out.println();
		
		Sparse s = sp.add(s1, s2);
		sp.display(s);

	}

	class Sparse {
		int m;
		int n;
		int nonZero;
		Element[] elements;

		public Sparse(int m, int n, int nonZero) {
			this.m = m;
			this.n = n;
			this.nonZero = nonZero;
			this.elements = new Element[nonZero];
		}
	}

	class Element {
		int i;
		int j;
		int val;
	}

}

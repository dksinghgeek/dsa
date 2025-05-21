package com.ggn.probs.dsa.ds.recursion;

import java.util.*;

public class StackRecursion {

	public Stack<Integer> sort(Stack<Integer> st) {
		if (st.isEmpty() || st.size() == 1) {
			return st;
		}

		int temp = st.pop();
		st = sort(st);
		st = insert(st, temp);

		return st;
	}

	private Stack<Integer> insert(Stack<Integer> st, int temp) {
		if (st.isEmpty() || st.peek() < temp) {
			st.push(temp);
			return st;
		}

		int val = st.pop();
		st = insert(st, temp);
		st.push(val);

		return st;
	}
	
	
	public void removeMiddleElement(Stack<Integer> st, int pos) {
		if(st == null || st.isEmpty())
			return;
		
		if(pos == 1) {
			System.out.println("Element : " + st.pop());
			return;
		}
		
		int temp = st.pop();
		pos--;
		removeMiddleElement(st, pos);
		st.push(temp);
	}
	
	public void reverse(Stack<Integer> st) {
		if(st == null || st.size() == 1)
			return;
		
		int temp = st.pop();
		reverse(st);
		reverseInsert(st, temp);
	}

	private void reverseInsert(Stack<Integer> st, int temp) {
		if(st.isEmpty()) {
			st.push(temp);
			return;
		}
		
		int t = st.pop();
		reverseInsert(st, temp);
		st.push(t);
	}

	public static void main(String[] args) {
		StackRecursion op = new StackRecursion();
		Stack<Integer> st = new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		
//		st = op.sort(st);
//		st.forEach(s -> System.out.println(s.intValue()));
//		
		
//		op.removeMiddleElement(st, 2);
		
		op.reverse(st);
		
		st.forEach(t -> System.out.print(" " + t.intValue()));
		
	}
}

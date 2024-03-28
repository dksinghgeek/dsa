package com.ggn.probs.dsa.ds.linkedlist;

import java.util.Stack;

public class LinearLinkedlistOperations {
	Node head;
	Node last;
	public void create(int[] keys) {
		if(keys.length == 0)
			return;
		
		Node t = new Node();
		t.data = keys[0];
		t.next = null;
		head = t;
		
		for(int i = 1; i < keys.length ; i++) {
			t = new Node();
			t.data = keys[i];
			t.next = head;
			head = t;
		}
	}
	
	public void display(Node p) {
		while(p != null) {
			System.out.print(" " + p.data);
			p = p.next;
		}
	}

	public Node rsearch(Node p, int x) {
		if(p == null)
			return null;
		else if(p.data == x) {
			return p;
		}else {
			return rsearch(p.next, x);
		}
	}
	
	public int length(Node p) {
		int length = 0;
		
		while(p != null) {
			length++;
			p = p.next;
		}
		
		return length;
	}
	
	public void insert(int index, int x) {
		Node p = head;
		
		if(index < 0 || index > length(p)) {
			return;
		}
		
		Node t = new Node();
		t.data = x;
		t.next = null;
		
		if(index == 0) {
			t.next = head;
			head = t;
		} else {
			for(int pos = 0 ; pos < index-1; pos++) {
				p = p.next;
			}
			
			t.next = p.next;
			p.next = t;
		}
	}
	
	public void removeDuplicate(Node p) {
		if(p == null)
			return;
		
		Node q = p.next;
		
		while(q != null) {
			if(q.data != p.data) {
				p = q;
				q = q.next;
			}else {
				p.next = q.next;
				q = p.next;
			}
			
		}
	}
	
	public void reverse1(Node p) {
		int[] A = new int[length(p)];
		
		Node q = p;
		int i = 0;
		while(q != null) {
			A[i] = q.data;
			q = q.next;
			i++;
		}
		
		q = p;
		i--;
		while(q != null) {
			q.data = A[i];
			q = q.next;
			i--;
		}
	}
	
	public void reverse2(Node p) {
		if(p == null)
			return;
		
		Node r = null; Node q = null;
		
		while(p != null) {
			r = q;
			q = p;
			p = p.next;
			q.next = r;
		}
		
		head = q;
	}
	
	public void reverse3(Node q , Node p) {
		if(p == null) {
			head = q;
		}else {
			reverse3(p, p.next);
			p.next = q;
		}
	}
	
	public boolean isLoop(Node t) {
		Node p = t; Node q = t;
		
		do {
			p = p.next;
			q = q.next;
			q = q != null ? q.next:q;
		}while(p!= null && q != null && p != q);
		
		return p == q ? true:false;
	}
	
	public void concat(Node p, Node q) {
		Node t = p;
		
		while(t.next != null) {
			t = t.next;
		}
		
		t.next = q;
	}
	
	public void insertLast(Node p, int x) {
		Node t = new Node();
		t.data = x;
		t.next = null;
		
		if(head == null) {
			head = t;
			last = head;
		}else {
			last.next = t;
			last = t;
		}
	}
	
	public boolean isSorted(Node p) {
		int INT_MIN = Integer.MIN_VALUE;
		
		while(p != null) {
			if(p.data < INT_MIN) {
				return false;
			}
			
			INT_MIN = p.data;
			p = p.next;
		}
		
		return true;
	}
	
	public void insert(Node p, int pos, int x) {
		if(pos < 0 || pos > length(p))
			return;
		
		Node t = new Node();
		t.data = x;
		t.next = null;
				
		if(pos == 0) {
			t.next = head;
			head = t;
		} else {
			for(int i = 0 ; i < pos-1; i++) {
				p = p.next;
			}
			
			t.next = p.next;
			p.next = t;
		}
	}
	
	public void delete(Node p , int pos) {
		if(pos < 1 || pos > length(p))
			return;
		
		if(pos == 1) {
			head = head.next;
		} else {
			Node q = null;
			
			for(int i = 0 ; i < pos - 1 ; i++) {
				q = p;
				p = p.next;
			}
			
			q.next = p.next;
		}
	}
	
	public Node middle(Node p) {
		Node q = p;
		
		while(p != null) {
			p = p.next;
			if(p != null) {
				p = p.next;
			}
			
			if(p != null) {
				q = q.next;
			}
		}
		
		return q;
	}
	
	public Node middleStack(Node p) {
		int n = length(p)/2;
		Stack<Node> st = new Stack<Node>();
		
		while(p != null) {
			st.push(p);
			p = p.next;
		}
		
		Node t = null;
		while(n>=0) {
			t = st.pop();
			n--;
		}
		
		return t;
	}
	
	public Node intersection(Node p, Node q) {
		Stack<Node> st1 = new Stack<Node>(); 
		Stack<Node> st2 = new Stack<Node>(); 
		
		while(p != null) {
			st1.push(p);
			p = p.next;
		}
		
		while(q != null) {
			st2.push(q);
			q = q.next;
		}
		
		Node t = null;
		while(st1.peek() == st2.peek()) {
			t = st1.pop();
			st2.pop();
		}
		
		return t;
	}
	
	public static void main(String[] args) {
		LinearLinkedlistOperations op = new LinearLinkedlistOperations();
		int[] keys = {5,4,3,2,1};
		op.create(keys);
//		op.display(op.head);
//		System.out.println();
//		System.out.println("rSearch : " + op.rsearch(op.head, 4).data);
//		
//		op.insert(0, 6);
//		op.insert(3, 7);
		
//		System.out.println();
//		op.removeDuplicate(op.head);
//		op.display(op.head);
		
//		System.out.println();
//		op.reverse3(null, op.head);
//		op.display(op.head);
		
//		System.out.println();
//		System.out.println(op.isLoop(op.head));
		
//		op.insertLast(op.head, 1);
//		op.insertLast(op.head, 2);
//		op.insertLast(op.head, 3);
//		
//		System.out.println();
//		op.display(op.head);
		
//		System.out.println(op.isSorted(op.head));
//		op.insert(op.head, 0, 7);
//		op.insert(op.head, 4, 8);
//		op.display(op.head);
		
//		
		System.out.println("Middle : " + op.middle(op.head).data);
		System.out.println("Middle : " + op.middleStack(op.head).data);
	}

}

package com.ggn.probs.dsa.ds.linkedlist;

public class CircularLinkedListOperations {
	Node head;
	int flag = 0;
	
	public void create(int[] A) {
		Node last;
		
		Node t = new Node();
		t.data = A[0];
		head = last = t;
		head.next = head;
		
		for(int i = 1 ; i < A.length ; i++) {
			t = new Node();
			t.data = A[i];
			t.next = last.next;
			last.next = t;
			last = t;
		}
	}
	
	public void display(Node p) {
		do {
			System.out.print(" " + p.data);
			p = p.next;
		}while(p != head);
	}
	
	public int length(Node p) {
		if(p == null)
			return 0;
		
		int len = 0;
		do {
			len++;
			p = p.next;
		}while(p != head);
		
		return len;
	}
	
	public void rDisplay(Node p) {
		if(p != head || flag == 0) {
			flag = 1;
			System.out.print(" " + p.data);
			rDisplay(p.next);
		}
		flag = 0;
	}
	
	public void insert(Node p, int x, int pos) {
		if(pos < 0 || pos > length(p))
			return;
		
		if(pos == 0) {
			Node t = new Node();
			t.data = x;
			
			if(head == null) {
				head = t;
				head.next = head;
				return;
			}
			
			while(p.next != head) {
				p = p.next;
			}
			
			t.next = p.next;
			p.next = t;
			head = t;
		}else {
			Node t = new Node();
			t.data = x;
			
			for(int i = 0 ; i < pos - 1 ; i++) {
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
			while(p.next != head) {
				p = p.next;
			}
			
			if(p == head) {
				head = null;
			}else {
				p.next = head.next;
				head = p.next;
			}
		} else {
			Node q = null;
			for(int i = 0 ; i < pos-1 ; i++) {
				q = p;
				p = p.next;
			}
			
			q.next = p.next;
		}
	}
	
	public static void main(String[] args) {
		CircularLinkedListOperations cp = new CircularLinkedListOperations();
		int[] keys = {1,2,3,4,5};
		
		cp.create(keys);
		cp.display(cp.head);
//		
//		System.out.println();
//		
//		System.out.println(cp.length(cp.head));
//		
//		System.out.println();
//		
//		cp.rDisplay(cp.head);
		
//		cp.insert(cp.head, 7, 2);
//		
//		System.out.println();
//		
//		cp.display(cp.head);
		
		System.out.println();
		
		cp.delete(cp.head, 5);
		
		cp.display(cp.head);
	}

}

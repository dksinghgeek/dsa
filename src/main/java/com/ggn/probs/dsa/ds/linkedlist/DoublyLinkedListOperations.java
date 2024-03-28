package com.ggn.probs.dsa.ds.linkedlist;

public class DoublyLinkedListOperations {
	Node head;
	
	public void create(int[] A) {
		if(A.length == 0)
			return;
		
		Node last;
		Node t = new Node();
		t.data = A[0];
		t.prev = null;
		t.next = null;
		
		head = last = t;
		
		for(int i = 1 ;i < A.length ; i++) {
			t = new Node();
			t.data = A[i];
			t.next = last.next;
			last.next = t;
			t.prev = last;
			last = t;
		}
	}
	
	public void display(Node p) {
		while(p != null) {
			System.out.print(" " + p.data);
			p = p.next;
		}
	}

	public int length(Node p) {
		int len = 0;
		
		while(p != null) {
			len++;
			p = p.next;
		}
		
		return len;
	}
	
	public void insert(Node p , int pos, int x) {
		if(pos < 0 || pos > length(p))
			return;
		
		Node t ;
		if(pos == 0) {
			t = new Node();
			t.data = x;
			t.prev = null;
			head.prev = t;
			t.next = head;
			head = t;
		}else {
			for(int i = 0 ; i < pos - 1 ; i++) {
				p = p.next;
			}
			
			t = new Node();
			t.data = x;
			t.next = p.next;
			t.prev = p;
			p.next = t;
			if(p.next != null)
				p.next.prev = t;
		}
	}
	
	public void delete(Node p , int pos) {
		if(pos < 1 || pos > length(p))
			return;
		
		Node t; Node q;
		if(pos == 1) {
			q = p;
			p = p.next;
			p.prev = null;
			head = p;
		} else {
			for(int i = 0 ; i < pos - 1 ; i++) {
				p = p.next;
			}
			
			p.prev.next = p.next;
			if(p.next != null)
				p.next.prev = p.prev;
		}
	}
	
	public void reverse(Node p) {
		Node t;
		while(p != null) {
			t = p.next;
			p.next = p.prev;
			p.prev = t;
			p = p.prev;
			
			if(p != null && p.next == null) {
				head = p;
			}
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedListOperations op = new DoublyLinkedListOperations();
		int[] keys = {1,2,3,4,5};
		
		op.create(keys);
		op.display(op.head);
//		System.out.println();
//		System.out.println(op.length(op.head));
//		
//		op.insert(op.head, 2, 6);
//		
//		System.out.println();
//		op.display(op.head);
//		
		System.out.println();
		
//		op.delete(op.head, 5);
		op.reverse(op.head);
		op.display(op.head);
	}
	
	class Node{
		Node prev;
		int data;
		Node next;
	}

}

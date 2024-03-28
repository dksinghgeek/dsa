package com.ggn.probs.dsa.ds.stack;

public class StackUsingLinkedlist {
	Node head = null;
	
	public boolean isEmpty() {
		return head == null ? true: false;
	}
	
	public boolean isFull() {
		Node t = new Node();
		return t == null ? true: false;
	}
	
	public void display() {
		Node p = head;
		
		while( p != null) {
			System.out.print(" " + p.data);
			p = p.next;
		}
	}
	
	public void push(int value) {
		if(isFull()) {
			System.out.println("Stack overflow!");
			return;
		}
		
		Node t = new Node();
		t.data = value;
		t.next = null;
		
		if(head == null) {
			head = t;
		} else {
			t.next = head;
			head = t;
		}
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack underflow !");
			return -1;
		}
		
		int x = head.data;
		head = head.next;
		
		return x;
		
	}

	public static void main(String[] args) {
		StackUsingLinkedlist st = new StackUsingLinkedlist();
		st.push(5);
		st.push(4);
		st.push(3);
		st.push(2);
		st.push(1);
		
		st.display();
		
		System.out.println();
		
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
	}
}

class Node {
	int data;
	Node next;
}
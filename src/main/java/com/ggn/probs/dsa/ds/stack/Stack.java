package com.ggn.probs.dsa.ds.stack;

public class Stack {
	private char[] stack;
	private int top;
	private int size;
	
	public Stack(int size) {
		this.size = size;
		this.top = -1;
		stack = new char[size];
	}
	
	public boolean isEmpty() {
		return top == -1 ? true:false;
	}
	
	public boolean isFull() {
		return top == size - 1 ? true:false;
	}
	
	public char top() {
		if(!isEmpty())
			return stack[top];
		return '0';
	}
	
	public void display() {
		if(!isEmpty()) {
			for(int i = top ; i >=0 ; i--) {
				System.out.print(" " + stack[i]);
			}
			System.out.println();
		}
	}
	
	public int peek(int pos) {
		if(top - pos + 1 < 0 || isFull()) {
			System.out.println("Invalid position!");
			return -1;
		}
		
		return stack[top-pos+1];
	}
	
	public void push(char value) {
		if(isFull()) {
			System.out.println("Stack overflow!");
			return;
		}
		
		stack[++top] = value;
	}
	
	public char pop() {
		if(isEmpty()) {
			System.out.println("Stack underflow!");
			return '\0';
		}
		
		char x = stack[top];
		top--;
		return x;
	}

	public static void main(String[] args) {
		Stack st = new Stack(5);
		st.push('a');
		st.push('b');
		st.push('c');
		st.push('d');
		st.push('e');
		st.display();
		
		System.out.println(st.peek(6));
	}

}

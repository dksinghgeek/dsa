package com.ggn.probs.dsa.ds.stack;

public class StackProbs {
	public boolean isBalanced(String exp) {
		if(exp == null || exp.length() == 0)
			return true;
		
		char[] expChars = exp.toCharArray();
		Stack st = new Stack(10);
		
		for(int i = 0 ; i < expChars.length ; i++) {
			if(expChars[i] == '(') {
				st.push(expChars[i]);
			} else if(!st.isEmpty() && expChars[i] == ')') {
				st.pop();
			}
		}
		
		return st.isEmpty() ? true: false;
	}
	
	public boolean isBalancedComplex(String exp) {
		if(exp == null || exp.length() == 0)
			return true;
		
		char[] expChars = exp.toCharArray();
		Stack st = new Stack(10);
		
		for(int i = 0 ; i < expChars.length ; i++) {
			if(expChars[i] == '(' || expChars[i] == '{' || expChars[i] == '[') {
				st.push(expChars[i]);
			} else if(expChars[i] == ')' || expChars[i] == '}' || expChars[i] == ']') {
				if((expChars[i] == ')' && st.top() == '(') || (expChars[i] == '}' && st.top() == '{') || (expChars[i] == ']' && st.top() == '[')) {
					st.pop();
				} else {
					return false;
				}
			}
		}
		
		return st.isEmpty() ? true : false;
	}
	
	public boolean isOperand(char ch) {
		if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
			return false;
		} else {
			return true;
		}
	}
	
	public int pre(char ch) {
		if(ch == '+' || ch == '-') {
			return 1;
		} else if(ch == '*' || ch == '/'){
			return 2;
		}
		
		return 0;
	}
	
	public String infixToPostfix(String exp) {
		char[] expChars = exp.toCharArray();
		int i = 0 ; int j = 0;
		char[] postfix = new char[exp.length()];
		Stack st = new Stack(10);
		
		
		while(i < expChars.length) {
			if(isOperand(expChars[i])) {
				postfix[j++] = expChars[i++];
			} else {
				if(pre(expChars[i]) > pre(st.top())){
					st.push(expChars[i++]);
				} else {
					postfix[j++] = st.pop();
				}
			}
		}
		
		while(!st.isEmpty()) {
			postfix[j++] = st.pop();
		}
		
		return String.valueOf(postfix);
	}
	
	public int eval(String exp) {
		char[] expChars = exp.toCharArray();
		java.util.Stack<Integer> st = new java.util.Stack<>();
		
		for(int i = 0 ; i < expChars.length ; i++) {
			if(isOperand(expChars[i])) {
				st.push(expChars[i] - '0');
			} else {
				int x2 = st.pop(); int x1 = st.pop();
				int r = 0;
				
				switch(expChars[i]) {
					case '+': r = x1 + x2; break;
					case '-': r = x1 - x2; break;
					case '*': r = x1 * x2; break;
					case '/': r = x1 / x2; break;
				}
				st.push(r);
			}
		}
		
		return st.peek();
	}

	public static void main(String[] args) {
		StackProbs op = new StackProbs();
		String exp = "a+b-c*d + f/j";
//		if(op.isBalancedComplex("[{a+b}-(c+d)] + (f+j)")) {
//			System.out.println("Balanced");
//		}else {
//			System.out.println("Not Balanaced");
//		}
		
//		System.out.println("infix to postfix : " + op.infixToPostfix(exp));
		
		System.out.println("Eval : " + op.eval("234*+82/-"));

	}

}

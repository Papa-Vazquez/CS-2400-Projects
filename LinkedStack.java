package project2package;

import java.util.Stack;

public class LinkedStack{

	//: Task 2
	
	static int p(char c) {
		switch (c) {
			case '+', '-':
				return 1;
			
			case '*', '/':
				return 2;
			case '^':
				return 3;
		}
		return -1;
	}
	
	static String infixToPostFix(String expression) {
		String result = "";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i <expression.length(); i++) {
			char c = expression.charAt(i);
			
			if(p(c)>0) {
				while(stack.isEmpty()==false && p(stack.peek())>=p(c)) {
					result += stack.pop();
				}
				stack.push(c);
			}else if(c==')') {
				char x = stack.pop();
				while(x!='(') {
					result += x;
					x = stack.pop();
				}
			}else if(c=='(') {
				stack.push(c);
			}else {
				result += c;
			}
		}
		
		for (int i=0; i <=stack.size(); i++) {
			result += stack.pop();
		}
		return result;
	
	}
	
	
}

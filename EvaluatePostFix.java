package project2package;

import java.util.Stack;

//: Task 5
public class EvaluatePostFix {
	
	public static Double evaluate(double a, double b, char operator) {
		switch (operator) {
		
			case '+':
				return a+b;
			
			case '-':
				return b-a;
			
			case '*':
				return a*b;
				
			case '/':
				if (a == 0)
					throw new
						UnsupportedOperationException("Cannot divide by zero");
				return b/a;
		}
		return 0.0;
		
	}
	
	public static Double convert(String expression) {
		Stack<Double> stack = new Stack<>();
		for (int i=0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			
			if (c == '*' || c == '/' || c == '^' || c == '+' || c == '-') {
				double d1 = stack.pop();
				double d2 = stack.pop();
				double temp = evaluate(d1, d2, c);
				stack.push(temp);
			}else {
				stack.push((double) (c-'0'));
			}
		}
		double result = stack.pop();
		return result;
	}
	


}

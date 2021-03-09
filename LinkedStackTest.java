package project2package;

//: Task 3
public class LinkedStackTest extends LinkedStack {

	public static void main(String[] args) {
		String expression = "a*b/(c-a)+d*e";
		System.out.println(expression.length());
		System.out.println("Infix Expression: " + expression);
		System.out.println("Postfix Expression: " + infixToPostFix(expression));
	}

}

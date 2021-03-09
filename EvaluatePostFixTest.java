package project2package;

public class EvaluatePostFixTest extends EvaluatePostFix {
	//: Task 6
		public static void main(String[] args) {
			String expression = "23*42-/56*+";
			System.out.println("Postfix Expression: " + expression);
			System.out.println("Evaluation: " + convert(expression));

		}
}

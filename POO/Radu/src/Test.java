import java.util.Scanner;


public class Test {

	public static void main(String[] args) throws EvaluatorException, SyntacticException {
			
		float result;
		String expression;
		Scanner s = new Scanner(System.in);
		
		expression = s.nextLine();
		ExpressionParser parser = new ExpressionParser();
		result=parser.eval(expression);
		System.out.println(result);
		s.close();
		
	}
}

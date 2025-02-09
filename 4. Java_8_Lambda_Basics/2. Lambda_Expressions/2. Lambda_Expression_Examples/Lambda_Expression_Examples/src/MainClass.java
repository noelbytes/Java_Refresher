
public class MainClass {
	public static void main(String[] args) {
		greetingFunction = () -> System.out.println("Hello World!");
		
//		greet(greetingFunction);
//		greet(() -> System.out.print("Hello World!"));
		
		doubleNumberFunction = (int a) -> {
			return a * 2;
		};
		
		// OR
		doubleNumberFunctionOneLine = (int a) -> return a * 2;
		
		// OR
		// If your lambda expression is one line, you can skip the return as well
		doubleNumberFunctionOneLineSkipReturn = (int a) -> a * 2;
		
		addFunction = (int number1, int number2) ->  number1 + number2;
		
		safeDivideFunction = (int firstInteger, int secondInteger) -> {
			if (secondInteger == 0) 
				return 0;
			return firstInteger / secondInteger;
		};
		
		stringLengthCountFunction = (String string) -> string.length();
	}
	
//	public void greet(____) {
//		_____();
//	}
}

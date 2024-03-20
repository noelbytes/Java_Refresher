/* What is a recursive method?
 * --> A method that calls itself
 * --> With each method call, the problem becomes simpler
 * --> Must have a condition that leads to the method no longer making another method call on itself
 * 
 * E.g. To method get a triangular number
 * public int getTriangularNumber(int number) {
 * 		if (number == 1) {
 * 			return 1;
 * 		} else {
 * 			return (number + getTraingularNumber(number - 1));
 * }
} 
*/

public class Recursion {
	public static void main(String[] args) {
		Recursion recursionTool = new Recursion();

//		recursionTool.calculateSquaresToPrint(6);

		System.out.println("Triangular Number : " + recursionTool.getTriangularNumber(6)); // 21 is the triangular number for 6
		System.out.println("-------------------------------------------");

		System.out.println("Triangular Number : (Using recursion) = " + recursionTool.getTriangularNumberByRecursion(6));
		System.out.println("-------------------------------------------");
//
		System.out.println("Factorial : (Using recursion) = " + recursionTool.getFactorialUsingRecursion(6));
		System.out.println("-------------------------------------------");

	}

	// Calculate triangular numbers without using recursion
	public int getTriangularNumber(int number) {
		int triangularNumber = 0;

		// 3 + 2 + 1 = 6

		while (number > 0) {
			triangularNumber = triangularNumber + number;
			number--;
		}

		return triangularNumber;
	}

	// Calculate triangular numbers using recursion
	public int getTriangularNumberByRecursion(int number) {

		System.out.println("Method " + number);

		// Base case
		if (number == 1) {
			System.out.println("Returned 1");
			return 1;
		} else {
			int result = number + getTriangularNumberByRecursion(number - 1);
			System.out.print("Returned " + result);
			System.out.println(" : " + number + " + getTN(" + number + " -1)");

			return result;
		}
	}

	// Calculating the factorial using recursion
	// F(3) = 3 * 2 * 1 = 6
	public int getFactorialUsingRecursion(int number) {
		System.out.println("Method " + number);

		if (number == 1) {
			System.out.println("Returned 1");
			return 1;
		} else {
			int result = number * getFactorialUsingRecursion(number - 1);
			System.out.print("Returned " + result);
			System.out.println(" : " + number + " * getFACT(" + number + " - 1)");

			return result;
		}
	}

	// USED TO DEMONSTRATE TRIANGULAR NUMBERS -----------------------

	// Draws the number of squares that are passed in horizontally

	public void drawSquares(int howManySquares) {
		for (int iteration = 0; iteration < howManySquares; iteration++) {
			System.out.print(" --  ");
		}

		System.out.println();

		for (int iteration = 0; iteration < howManySquares; iteration++) {
			System.out.print("|" + howManySquares + " | ");
		}

		System.out.println();

		for (int iteration = 0; iteration < howManySquares; iteration++) {
			System.out.print(" --  ");
		}

		System.out.println("\n");
	}

	// Outputs the number of squares to print to represent a triangle
	public void calculateSquaresToPrint(int count) {
		for (int number = 1; number <= count; number++) {
			for (int numberOfSquares = 1; numberOfSquares < number; numberOfSquares++) {
				drawSquares(numberOfSquares);
			}
			System.out.println("Triangular Number : " + calculateTraingularNumber(number));
		}
	}

	public double calculateTraingularNumber(int number) {
		return .5 * number * (1 + number); // Formula to calculate triangular numbers : (n * (n + 1)) / 2
	}
}

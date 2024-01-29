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
		
		recursionTool.calculateSquaresToPrint(6);
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
	public void calculateSquaresToPrint(int number) {
		for (int index1 = 1; index1 <= number; index1++) {
			for (int index2 = 1; index2 < index1; index2++) {
				drawSquares(index2);
			}
			System.out.println("Triangular Number : " + calculateTraingularNumber(index1));
		}
	}
	
	public double calculateTraingularNumber(int number) {
		return .5 * number * (1 + number);
	}
}

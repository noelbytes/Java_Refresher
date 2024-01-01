/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.corejava.operators;

/**
 *
 * @author noelbytes
 */
public class Operators {

    public static void main(String[] args) {
        
        // Arithmetic operators
        float x = 3 + 2; // 5 Addition
        x = 3 - 2; // 1 Subtraction
        x = 3 * 2; // 6 Multiplication
        x = 3 / 2; // 1 Division - this will round off the result and return the integer value
        
        // To get the accurate result in case of division, explicilty convert one of the numbers to 
        // a floating point number
        x = (float) 3 / 2;
        x = 3 % 2; // 1 Modulus (Division remainder)
        
        // Assignment operators
        // Common use of assignment and arithmetic operators 
        // - used to operate on a variable and then save the result back into 
        // that same variable
        int a = 0;
        a = a + 5;
        a = a - 5;
        a = a * 5;
        a = a / 5;
        a = a % 5;
        
        // Same operation using combined assignment operators
        a += 5; // a = a + 5
        a -= 5; // a = a - 5
        a *= 5; // a = a * 5
        a /= 5; // a = a / 5
        a %= 5; // a = a % 5
        
        // Increment and decrement operators - used to increment / decrement a 
        // variable by 1
        int i = 0;
        ++i; // i += 1;
        --i; // i -= 1;
        
        ++i; // pre-increment
        --i; // pre-decrement
        i++; // post-increment
        i--; // post-decrement
        
        // Difference between post and pre operators
        int y = 0, z;
        y = 5; z = y++;  // z = 5, y = 6
        // The post operator returns the original value before it changes the 
        // variable
        
        // The pre operator changes the variable first and then returns the value
        y = 5; z = ++y;   // y = 6; z = 6
        
        // Comparison operators - compares two values and returns either true or 
        // false
        boolean x1 = (2==3); // false // Equal to
        x1 = (2 != 3);  // true // Not equal to
        x1 = (2 > 3);   // false    // Greater than
        x1 = (2 < 3);   // true     // Less than
        x1 = (2 >= 3);  // false    // Greater than or equal to
        x1 = (2 <= 3);  // true    // Less than or equal to
        
        // Logical operators
        // NOTE: For logical OR and logical AND, the right hand side won't be 
        // evaluated if the result is already determined by the left side
        x1 = (true && false); // false // And
        x1 = (true || false);   // true     // Or
        x1 = !(true);   // false    // Not
        
        // Bitwise operators
        int x2 = 5 & 4; // 101 & 100 = 100 (4) // and
        x2 = 5 | 4; // 101 | 100 = 101 (5) // or
        x2 = 5 ^ 4; // 101 ^ 100 = 001 (1) // xor
        x2 = 4 << 1; // 100 << 1 = 1000 (8) // left shift
        x2 = 4 >> 1; // 100 >> 1 = 10 (2) // right shift
        x2 = 4 >>> 1; // 100 >>> 1 = 010 (2) // right shift zero-fill
        // NOTE: >>> zero-fill right shift moves all the bits to the right 
        // including the signed bit
        
        x2 = ~4; // ~00000100 = 11111011 (-5 : by using 2s complement) // invert
        
        // Operator precedence
        boolean x3;
        // the logical operator binds weaker than the relational operator, which 
        // in-turn binds weaker than the arithmetic operators
        // i.e. logical < relational < arithmetic 
        x3 = 2 + 3 > 1 * 4 && 5 / 5 == 5; // false
        
        // to give more precedence to a certian expression, use () 
        x3 = ((2 + 3) > (1 * 4)) && ((5  / 5) == 5);    // false
    }
}

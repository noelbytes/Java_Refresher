/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.corejava.stringdemo;

/**
 *
 * @author noelbytes
 */
public class StringDemo {

    public static void main(String[] args) {
        // NOTE: String in Java is a reference data type
        // All non-primitive data types in Java are reference data types
        String a = "Hello ";
        String b = new String("World");
        String c = a + b;   // Hello World
        a += b; // Hello World
        
        // NOTE: While we can split a statement across multiple lines, we 
        // can't split a string. 
        // i.e. String x
        //              = "Hello 
        //                  World" will result in a error
        
        // In order to solve this, use the concatenation operator, as in the 
        // example below
        String x 
                = "Hello "
                + "World";
        
        String x1 = 
                "\n" + /* newline */        "\f" + // formfeed
                "\t" + /* tab */            "\'" + // single quote
                "\b" + /* backspace */      "\"" + // double quote
                "\r" + /* carriage return */ "\\" + // backslash
                "\u0000";   // unicode character (4-digit hex number)
        
        // Comparing two strings
        boolean isEqualString = a.equals(b);    // compares strings
        boolean isEqualAddress = (a == b);  // compares addresses
        
        // NOTE: All strings in Java are objects. So we can call methods directly 
        // on constant strings
        boolean isStringEqual = "Hello ".equals(a);
        
        // NOTE: The String class in Java contains no methods to manipulate 
        // Strings. This is because strings in Java are immutable. Once a string 
        // has been created, the contents cannot be changed, unless the whole 
        // string is completely replaced. 
        
        // For cases where we would need a modifiable string, we instead use the 
        // StringBuffer class, which is a mutable String object. This class 
        // has several methods to manipulate Strings, such as append, delete 
        // and insert. To convert it back to a regular String, there's a toString()
        // method
        StringBuffer stringBuffer = new StringBuffer("Hello");
        a = stringBuffer.toString();
        
    }
}

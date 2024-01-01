/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.corejava.functions;

/**
 *
 * @author noelbytes
 */
public class Functions {

    public static void main(String[] args) {
        Functions functions = new Functions();
        functions.myPrint();    // Hello
        functions.myPrint("Hello");
        System.out.println(functions.getPrint());
        functions.myPrint(313);
        
        // Pass by value and pass by reference
        int x = 0;  // Primitive datatype
        functions.set(x);   // Only the value of x is passed. In this case, only
        // a local copy of the variable is changed within the method, so the change will 
        // not affect the original variable
        System.out.println(x);
        
        // Reference datatypes
        int[] y = {0};  // reference datatype
        functions.set(y);   // only the address is passed
        System.out.println(y[0]);     // 10
    }
    
    void myPrint() {
        System.out.println("Hello");
    }
    
    void myPrint(String s) {
        System.out.println(s);
        return; // We can also use the return keyword in the void function - to exit before 
                // the end block is reached
    }
    
    void myPrint(int i) {   // Method overloading
        System.out.println(i);
    }
    
    String getPrint() {
        return "Hello";
    }
    
    void set(int a) {
        a = 10;
    }
    
    void set(int[] a) {
        a = new int[] { 10 };
    }
}

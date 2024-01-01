/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.myapp;

/**
 *
 * @author noelbytes
 */
public class MyApp {

    /**
     * The main method of the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        
        int myInt = 10, myInt2 = 20, myInt3;
        
        // Four signed integer types
        byte myInt8 = 2;    // -128 to +127 (-2^7 to 2^7)
        short myInt16 = 1;  // -32768 to 32767   
        int myInt32 = 0;    // -2^31 to + 2^31-1
        long myInt64 = -1;  // -2^63 to +2^63-1
        
        // In addition to standard decimal notation, integers can also 
        // be assigned using octal or hexidecimal notation
        int myHex = 0xF;    // hexidecimal (base 16)
        int myOct = 07;     // octal (base 8)
        
        // The floating point types can store integers as well as floats
        float myFloat = 3;
        // float myFloat2 = 3.14;   - constant floating point numbers in Java 
        //                            are always treated as a double type. To 
        //                            assign it correctly, append an F character 
        //                            to the constant, which says that this number 
        //                            is in fact a float
        float myFloat2 = 3.14F;       // or 3.14f 
        
        // another way - using explicit typecasting
        float myFloat3 = (float) 3.14;
        
        double myDouble = 3.14;
        
        // They can also be assigned using the standard exponental notation
        double myDoubleExp = 3e2;   // 3*10^2 = 300
        
        char myChar = 'A';  // unicode character
        // It can also be assigned using a special notation, that will give you 
        // access to all Unicode characters
        char myChar2 = '\u0000';    // \u0000 to \uFFFF
        
        // booleans can either be true or false
        boolean myBool = false;
        
        
        // Default values of primitives 
        
                        // default value
        byte myInt8bit; // 0
        short myInt16bit;   // 0
        int myInt32bit;        // 0
        long myInt64bit;       // 0
        
        float myFloatDefault;   // 0.0
        double myDoubleDefault; // 0.0
        
        char myCharDefault;        // '0' or '\u0000'
        boolean myBooleanDefault;   // false
        
        
        System.out.println("Hello World!");
        // single line comment
        /* multi-line 
		   comment */
        
        System.out.print(myInt);
    }

}

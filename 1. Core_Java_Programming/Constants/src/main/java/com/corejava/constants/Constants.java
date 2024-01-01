/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.corejava.constants;

/**
 *
 * @author noelbytes
 */
public class Constants {

    public static void main(final String[] ARG_VARS) {
        final double PI = 3.14;     // run-time constant
        // PI = 4; // not possible, since PI is a constant
    }
    
//    final double E = 2.72;       // run time constant
//    static final double C = 3e8;  // compile-time constant
    
    // instance and class constants can also alternatively be assigned in a 
    // constructor and a class construct (static block).
    final double E;
    static final double C;
    final static int RANDOM = (new java.util.Random().nextInt());    // run-time constant
    // Run-time constants can be assigned dynamic values that can change from one 
    // program run to another.
    public Constants() {
        E = 2.72;
    }
    
    static {
        C = 3e8;
    }
}

// use final if you don't want the variables to be reassigned

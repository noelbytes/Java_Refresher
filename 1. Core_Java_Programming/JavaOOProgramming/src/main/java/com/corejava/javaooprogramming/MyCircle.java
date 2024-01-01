/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.corejava.javaooprogramming;

/**
 *
 * @author noelbytes
 */
public class MyCircle {
    // The static keyword is used to declare fields and methods 
    // that can be accessed without having to create an instance of the class
    float r = 10;   // instance variable
    static float pi = 3.14F;    // class variable
    
    // NOTE: static members exists in only one copy to the class itself,
    // whereas instance members are created as new copies for each new object
    
    /** 
     * instance method
     */
    float getArea() {
//        return 0;
        // NOTE: Instance members can use both static and instance members
        return computeArea(r);
    }
    
    /** 
     * class method
     */
    static float computeArea(float a) {
//        return 0;
        // NOTE: Static methods cannot use instance members, since 
        // these members are not a part of the instance
        return pi * a * a;
    }
    
    // REMEMBER: When should you use static methods?
    // --> Methods should be declared static if they perform a generic function 
    // that is independent of any instance variables. A good example of this is the 
    // Math class which contains onyl static methods and fields
}

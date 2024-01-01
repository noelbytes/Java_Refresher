/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.corejava.javaooprogramming;

/**
 *
 * @author noelbytes
 */
public class MyNewCircle {
    
    // NOTE: static fields have the advantage that they persist throughout the life of 
    // the application. They can therefore, as an example, be used to record the 
    // number of times that a function has been called across all instances of the class
    static float pi = 3.14F;
    
    static float computeArea(float a) {
        count++;
        return pi * a * a; 
    }
    
    // The initial value for a static field will be set only once, sometimes 
    // before the class or field is ever used
    static int count = 0;
    static int[] array = new int[5];
    // If the initialization requires more than one line, or some other 
    // logic, a static initialization block can be used. This block, in 
    // contrast to the constructor, will only be run once at the same time 
    // the static fields are initialized. 
    static {
        for (int element : array) {
            element = (int) (pi * pi);
        }
    }
}

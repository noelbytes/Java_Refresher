/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.corejava.javaooprogramming;

/**
 *
 * @author noelbytes
 */
public class MyRectangle {

    // We can also assign the values to the field of the class when they are 
    // first declared. These default values will be assigned even before the 
    // constructor is called
    int x = 30, y = 40;

    int getArea() {
        return x * y;
    }

    public MyRectangle() {
        // If the constructor needs to be accessible from another class, it 
        // needs to be declared with the public access modifier
//        x = 10;
//        y = 5;
// NOTE: The this keyword can also be used to call one constructor from another
        this(10, 20); // Calls MyRectangle(int x, int y)
        // NOTE: The this keyword here represents a function call, and they must 
        // always be the first line in the constructor. 
    }

    public MyRectangle(int a) {
//        x = a;
//        y = a;
        this(a, a);
    }

    public MyRectangle(/* int width, int height*/int x, int y) {
//        x = width;
//        y = height;
// NOTE: The this keyword is a reference to the current instance of the class
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        MyRectangle myRectangle = new MyRectangle();
        MyRectangle myRectangle2 = new MyRectangle(20, 15);
    }
}

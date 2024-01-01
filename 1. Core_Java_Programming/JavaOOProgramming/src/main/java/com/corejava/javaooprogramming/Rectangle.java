/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.corejava.javaooprogramming;

/**
 *
 * @author noelbytes
 */
public class Rectangle {

    public int w = 10, h = 10;

    // If you want to prevent the instance methods from being overridden in the 
    // subclasses, we can declare it using the final method modifier. 
    public /* final */ int getArea() {
        return w * h;
    }

    public Rectangle() {
    }

    public Rectangle(int a, int b) {
        w = a;
        h = b;
    }
    
    public static int newArea(int a, int b) {
        return a * b;
    }
    
}

class Triangle extends Rectangle {

    public Triangle() {
        // Here, if we don't have a call to any other constructor on the first line
        // the Java compiler will automatically add a call to the superclass' no parameter 
        // constructor in order to make sure that all ancestor classes of this class 
        // are properly constructed.
        super();
    }
    
    public Triangle(int a, int b) {
        super(a, b);
    }
    
    @Override
    public int getArea() {
//        return w * h / 2;
        return super.getArea(); // reference to the current instance of the superclass
    }

    void test() {
        Triangle triangle = new Triangle();
        triangle.getArea(); // 50 - calls Triangle's version

        // If we upcast it to a Rectangle, the getArea method defined in the 
        // Triangle class will still be called, since Rectangle's version has been 
        // overridden 
        // NOTE: This is only true for instance methods, and not for class (static) methods
   
        Rectangle object = new Triangle();
        object.getArea();   // calls Triangle's version
        object.newArea(10, 10);   // calls Rectangle's version
    }
    
    public static int newArea(int a, int b) {
        // Here, the Triangle's version will only hide rectangles implementation, and 
        // therefore, we won't need to use the override annotation.
        return a * b / 2;
    }
    
}

// Remember: Redefined instance methods will always be overridden in Java, and 
// redefined class (static) methods will always be hidden, and there's no way to change that
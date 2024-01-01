/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.corejava.abstractclassdemo;

/**
 *
 * @author noelbytes
 */
abstract class Shape {

    public int x = 100, y = 100;

    public Shape(int a, int b) {
        x = a;
        y = b;
    }

    public abstract int getArea();
}

interface Comparable {

    int compare();
}

// Difference between an abstract class and a interface
// Abstract class - defines default functionality and definitions
// Interface - Defines an interface or a specific functionality
// A class can inherit only from one class, abstract or not, whereas it can implement multiple interfaces
// We generally use an interface either to specify a specific functionality that a class can have, or to provide 
// an interface to other programmers using our classes, and we use an abstract class when we want to provide 
// a partial implementation, leaving it up to the subclasses to complete it. This is useful when the subclasses have a lot of 
// functionality in common, but also have some functionality that must be implemented differently for each subclass.

class Rectangle extends Shape {

    // NOTE: If Rectangle is declared abstract. it doesn't have to implement any abstract methods.
    
    public Rectangle() {
        super(0, 0);
    }

    public Rectangle(int a, int b) {
        super(a, b);
    }

    @Override
    public int getArea() {
        return x * y;
    }
}

public class AbstractClassDemo {

    public static void main(String[] args) {
        // An abstract class cannot be instantiated, but we can use it to encapsulate any of it's subclasses
        Shape s = new Rectangle();
    }
}

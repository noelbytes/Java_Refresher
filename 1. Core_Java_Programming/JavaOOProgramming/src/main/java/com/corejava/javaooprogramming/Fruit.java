/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.corejava.javaooprogramming;

/**
 *
 * @author noelbytes
 */
// Superclass (parent class)
public class Fruit extends Object {

    public String flavour;

    public String getName() {
        return getClass().getName();
    }
}

// Subclass (child class)
// In addition to it's own members, Apple now gains all accessible members in Fruit, 
// except for it's constructors. The other members seen here all come from the root class 
// object
class Apple extends Fruit {

    public String variety;
    
    void test() {
        Apple apple1 = new Apple();
        Fruit fruit = apple1;    // Class upcasting. The apple is now seen as a fruit, 
        // so we can only see the fruits members
        // Apple apple2 = (Apple) fruit;   // Class downcasting
        Apple apple2 = (fruit instanceof Apple) ? (Apple) fruit : null;
    }
}

// NOTE: A class in Java may inherit from one superclass, and if you don't specify one,
// it will implicitly inherit from Object. 
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.corejava.interfacedemo;

/**
 *
 * @author noelbytes
 */
interface Comparable {

    int Compare(Object o);
}

class Circle extends Object implements Comparable {

    public int r;

    @Override
    public int Compare(Object o) {
        return r - ((Circle) o).r;
    }
}

class MyClass {
    public static Object Largest(Comparable a, Comparable b) {
        return (a.Compare(b) > 0) ? a : b;
    }
}

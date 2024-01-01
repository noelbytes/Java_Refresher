/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.corejava.interfacedemo;

/**
 *
 * @author noelbytes
 */
// The access for a interface is package-private by default
// All members in the interface are public by default
public interface MyInterface {

    // Interface method
    public int myMethod();

    // Interface constant
    // Any field declared in the interface is static final by default, so this can be left out
    static final int c = 10;

    // Interface type - can also contain nested types - such as classes and other interfaces
    class Class {
    }

    class HelperClass {
        // This can be used to provide static helper methods
        public static void Helper() {
            return;
        }
    }
    
    interface Interface {
    }

    enum Enum {
    }
}

class MyClass implements MyInterface {
    
    
    void test() {
        HelperClass.Helper();
        // The class in the interface can be used by classes implementing the interface
        // They will not however be visible to other objects using the interface
    }

    @Override
    public int myMethod() {
        return 0;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.corejava.accesslevels;

/**
 *
 * @author noelbytes
 */
public class AccessLevels {

    public int myPublic;            // unrestricted access
    protected int myProtected;      // own package or derived class
        int myPackagePrivate;       // own package
    private int myPrivate;          // own class
    
    void test() {
        myPublic = 0;   // allowed
        myProtected = 0;    // allowed
        myPackagePrivate = 0;  // allowed
        myPrivate = 0;          // allowed
    }
    
    private class MyClass {
        
    }
}

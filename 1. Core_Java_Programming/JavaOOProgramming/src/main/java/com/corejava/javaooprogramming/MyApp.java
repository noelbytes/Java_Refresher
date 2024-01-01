/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.corejava.javaooprogramming;

/**
 *
 * @author noelbytes
 */
public class MyApp {
    public static void main(String[] args) {
        
        float f = MyCircle.pi;
        MyCircle c = new MyCircle();
        float g = c.r;
        
        // NOTE: If you try to access a static member using a object reference instead 
        // of the class name, we'll get a warning, since this makes it harder to see 
        // that we're using a static member
        double d = Math.PI;
    }
}

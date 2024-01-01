/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.corejava.conditionals;

/**
 *
 * @author noelbytes
 */
public class Conditionals {

    public static void main(String[] args) {
        double x = Math.random();   // value between 0 and 1
        if (x < 0.5) {
            System.out.println(x + " < 0.5");
        } else if (x > 0.5) {
            System.out.println(x + " > 0.5");
        } else {
            System.out.println(x + " == 0.5");
        }
        
        // switch statement
        int y = (int) Math.round(x);    // get nearest integer
        switch (y) {
            case 0:
                System.out.println(y + " is 0");
                break;
            case 1:
                System.out.print(y + " is 1");
                break;
            default:
                System.out.print(y + " is something else");
        }
        
        // ternary operator
        x = (x < 0.5) ? 0 : 1;  // equivalent of if (x < 0.5) {
                                //                  x = 0;
                                //               } else {
                                //                  x = 1;
                                //               }
    }
}

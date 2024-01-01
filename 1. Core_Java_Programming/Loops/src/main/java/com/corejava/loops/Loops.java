/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.corejava.loops;

/**
 *
 * @author noelbytes
 */
public class Loops {

    public static void main(String[] args) {

        // While loop
        System.out.println("While Loop\n------------------");
        int i = 0;
        while (i < 10) {
            System.out.println(i++);
        }

        System.out.println("------------------------\nDo While Loop\n-----------------------------");
        int j = 0;
        do {
            System.out.println(j++);
        } while (j < 10);

        System.out.println("------------------------\nFor Loop\n-----------------------------");
        for (int k = 0; k < 10; k++) {
            // NOTE: The condition is checked before each iteration
            // The increment to the counter is executed at the end of each 
            // iteration
        }

        // Different variations of for
        for (int k = 0, l = 10; k < 10; k++, l--) {
            // NOTE: The condition is checked before each iteration
            // The increment to the counter is executed at the end of each 
            // iteration
        }

        // Moving the third parameter into the body of the loop
        for (int k = 0, l = 10; k < 10;) {
            System.out.println(k + 1);
            k++;
            l--;
        }

        // For each loop - provides an easier way to iterate over arrays
        int[] n = {1, 2, 3};
        System.out.print("[ ");
        for (int m : n) {
            System.out.print(m + " ");
        }
        System.out.println("]");

        // break and continue keyword
        myLoop:
        for (int iterator = 0, j1 = 0; iterator < 10; iterator++) {
            while (++j < 10) {
                // break;   // end while
                // continue; // start next while
                break myLoop;   // end for
                // continue myLoop;    // proceed with the next iteration of for
            }
        }
    }
}

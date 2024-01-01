/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.corejava.arraydemo;

/**
 *
 * @author noelbytes
 */
public class ArrayDemo {

    public static void main(String[] args) {
        
        // Declaration of a array
        int[] x;
        // OR
        int y[];
        
        // Arrays can be declared with any data type, and all of it's elements 
        // must be of that type
        
        // Allocating memory for an array
        int z[] = new int[3]; // once an array is created, the elements are 
                              // automatically assigned to the default value for
                              // that type. In this case, [0, 0, 0]
        z[0] = 1;
        z[1] = 2;
        z[2] = 3;
        
        // To assign elements all at once
        int[] a = new int[] {1, 2, 3};
        // OR
        int[] b = {1, 2, 3};
        
        System.out.println(b[0] + b[1] + b[2]);  // 6
        
        // Multi-dimensional arrays
        String[][] multiDimensionalArray1 = {{"00", "01"}, {"10", "11"}};
        String[][] multiDimensionalArray2 = new String[2][2];
        multiDimensionalArray2[0][0] = "00";
        multiDimensionalArray2[0][1] = "01";
        multiDimensionalArray2[1][0] = "10";
        multiDimensionalArray2[1][1] = "11";
        System.out.print(multiDimensionalArray1[0][0] + multiDimensionalArray1[1][1]);   // 0011
        
        // NOTE: The length of the array is fixed, and there are no methods to change 
        // their size. The only array function that we normally have use for is the 
        // length method, to get the size of the array.
        System.out.println("Length of the array : " + multiDimensionalArray1.length);
        
        // For cases where we'll need a resizable array, we can instead use the 
        // ArrayList class, located in the java.util package
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(5);
        // To extract an element from a ArrayList, we can use the get method
        System.out.println(arrayList.get(0));
    }
}

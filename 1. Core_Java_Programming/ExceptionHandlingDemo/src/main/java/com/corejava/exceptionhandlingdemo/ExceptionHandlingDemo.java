/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.corejava.exceptionhandlingdemo;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author noelbytes
 */
public class ExceptionHandlingDemo {

    public static void main(String[] args) {
        FileReader in = null;
        try {
            in = new FileReader("Missing.file");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {

        } finally {
            if (in != null)
                try {
                in.close();
            } catch (IOException e) {

            }
        }
        try {
            makeException();
        } catch (IOException e) {

        }
    }

    static void makeException() throws IOException, ArithmeticException {
//        throw new Throwable("My Throwable");
        throw new IOException("My IO Exception");
//        throw new ArithmeticException("Division by zero");
    }
}

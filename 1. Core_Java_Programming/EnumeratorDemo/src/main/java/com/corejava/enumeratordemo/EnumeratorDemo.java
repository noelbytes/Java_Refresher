/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.corejava.enumeratordemo;

/**
 *
 * @author noelbytes
 */
// An enumerator is a type that contains a fixed list of named constants
// Access level for a enumerator - package private (by default)
enum Speed {
    STOP(0), SLOW(5), NORMAL(10), FAST(20);

    public int speed;

    Speed(int s) {
        speed = s;
    }
}

public class EnumeratorDemo {

    public static void main(String[] args) {
        Speed s = Speed.SLOW;

//        switch (s) {
//            case SLOW:
//                break;
//        }
        System.out.println(s.speed);
        System.out.println(Speed.values());
        
        for (Speed speedReference : Speed.values()) {
            System.out.println(speedReference.name() + " = " + speedReference.speed);
        }
    }
}

// Enumerators can also be declared within a class
class MyApp {

    enum NewSpeed {
        STOP, SLOW, NORMAL, FAST;
    }
}

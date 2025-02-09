package io.noelbytes;
/**
 * Code in OOP
 * -------------
 * - Everything is an object. You cannot have a piece of functionality that exists in isolation. It has to be a part of a class, a part of an object. 
 * - All code blocks are "associated" with classes and objects. 
 */


public class Greeter {
	
	public void greet() {
		System.out.println("Hello world!");
	}
	
	/**
	 * What if we want dynamic inputs to the greeting method? 
	 * One way to do this in Java 7 is to create an interface called Greeting, which has 
	 * a perform(), and you pass to the greet method an instance of this Greeting interface. 
	 * You create an implementation of the Greeting interface which has a particular implementation 
	 * of the perform method.
	 */
	public void greet(Greeting greeting) {
		greeting.perform();
	}
	
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		greeter.greet();
		
		// This is classic Object Oriented programming - an example of polymorphism
		HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
		greeter.greet(helloWorldGreeting);
	}
}

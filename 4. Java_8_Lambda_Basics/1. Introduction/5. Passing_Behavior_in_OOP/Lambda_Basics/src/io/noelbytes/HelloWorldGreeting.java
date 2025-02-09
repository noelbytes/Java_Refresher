package io.noelbytes;

public class HelloWorldGreeting implements Greeting {
	
	@Override
	public void perform() {
		System.out.println("Hello World! from the Hello World Greeting class");
	}
}

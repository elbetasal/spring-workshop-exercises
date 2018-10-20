package org.developer.elbetasal.spring.course.exercise2;

public class SpanishGreetingService implements GreetingService {

	@Override
	public String greet(String name) {
		return "Hola " +name;
	}


}

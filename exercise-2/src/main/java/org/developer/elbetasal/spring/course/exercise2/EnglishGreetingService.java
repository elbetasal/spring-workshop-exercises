package org.developer.elbetasal.spring.course.exercise2;

public class EnglishGreetingService implements GreetingService {

	@Override
	public String greet(String name) {
		return "Hello " + name;
	}

}

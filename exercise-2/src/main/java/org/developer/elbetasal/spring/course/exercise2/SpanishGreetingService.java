package org.developer.elbetasal.spring.course.exercise2;

import org.springframework.stereotype.Service;

@Service("spanishGreeting")
public class SpanishGreetingService implements GreetingService {

	@Override
	public String greet(String name) {
		return "Hola " +name;
	}


}

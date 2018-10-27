package org.developer.elbetasal.spring.course.exercise2;

import org.springframework.stereotype.Service;

@Service("extenalFrenchService")
public class ExternalFrenchService {

	//TODO Inject this value with a property called spring.course.french.greeting
	private String frenchGreeting;

	public String retrieveFrenchGreeting() {
		return this.frenchGreeting;
	}

}

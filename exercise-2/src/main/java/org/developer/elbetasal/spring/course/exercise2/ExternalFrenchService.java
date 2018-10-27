package org.developer.elbetasal.spring.course.exercise2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("extenalFrenchService")
public class ExternalFrenchService {

	//TODO Inject this value with a property called spring.course.french.greeting
	private final String frenchGreeting;

	public ExternalFrenchService(@Value("${spring.course.french.greeting:not_found}") String frenchGreeting) {
		this.frenchGreeting = frenchGreeting;
	}


	public String retrieveFrenchGreeting() {
		return this.frenchGreeting;
	}

}

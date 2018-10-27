package org.developer.elbetasal.spring.course.exercise2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("frenchGreetingService")
public class FrenchGreetingService implements GreetingService {

	private final ExternalFrenchService fakeService;

	@Autowired
	public FrenchGreetingService(ExternalFrenchService fakeService) {
		this.fakeService = fakeService;
	}

	@Override
	public String greet(String name) {
		return fakeService.retrieveFrenchGreeting() + " " + name;
	}
}

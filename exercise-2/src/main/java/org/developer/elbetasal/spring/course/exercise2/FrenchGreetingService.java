package org.developer.elbetasal.spring.course.exercise2;

public class FrenchGreetingService implements GreetingService {

	private final ExternalFrenchService fakeService;

	public FrenchGreetingService(ExternalFrenchService fakeService) {
		this.fakeService = fakeService;
	}

	@Override
	public String greet(String name) {
		return fakeService.retrieveFrenchGreeting() + " " + name;
	}
}

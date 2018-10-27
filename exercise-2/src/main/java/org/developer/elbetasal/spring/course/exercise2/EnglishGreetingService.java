package org.developer.elbetasal.spring.course.exercise2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("englishGreeting")
@Scope("prototype")
public class EnglishGreetingService implements GreetingService {

	@Override
	public String greet(String name) {
		return "Hello " + name;
	}

}

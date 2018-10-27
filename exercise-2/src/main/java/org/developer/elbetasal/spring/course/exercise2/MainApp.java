package org.developer.elbetasal.spring.course.exercise2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class MainApp {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainApp.class);

		GreetingService englishGreetingService = applicationContext.getBean("englishGreeting" , GreetingService.class);
		System.out.println(extractGreetingMessage(englishGreetingService, "FMAT"));
		englishGreetingService = applicationContext.getBean("englishGreeting" , GreetingService.class);
		System.out.println(extractGreetingMessage(englishGreetingService, "FMAT"));

		GreetingService spanishGreetingService = applicationContext.getBean("spanishGreeting" , GreetingService.class);
		System.out.println(spanishGreetingService.greet("FMAT"));

		GreetingService frenchGreetingService = applicationContext
				.getBean("frenchGreetingService" , GreetingService.class);
		System.out.println(frenchGreetingService.greet("FMAT"));

		GreetingService encryptedGreetingService = applicationContext.getBean("encryptedGreeting" , GreetingService.class);
		System.out.println(encryptedGreetingService.greet("FMAT"));
		((AnnotationConfigApplicationContext) applicationContext).registerShutdownHook();
	}

	private static String extractGreetingMessage(GreetingService greetingService, String name) {
		return String.format("Greet from %s with %s", greetingService, greetingService.greet(name));
	}

}

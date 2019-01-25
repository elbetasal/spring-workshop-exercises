package org.fmat.intro.hibernate.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class SpringApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SpringApp.class);

		StudentRepository repository = context.getBean(StudentRepository.class);
		context.registerShutdownHook();
	}
}

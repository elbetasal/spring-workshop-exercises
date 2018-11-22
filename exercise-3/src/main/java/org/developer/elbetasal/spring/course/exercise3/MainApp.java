package org.developer.elbetasal.spring.course.exercise3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(AppConfig.class);

		StudentRepository repository = annotationConfigApplicationContext.getBean(StudentRepository.class);
		repository.create("Jose" , 21);
		repository.findAllStudents()
				.stream()
				.forEach(System.out::println);

		annotationConfigApplicationContext.registerShutdownHook();
	}
}

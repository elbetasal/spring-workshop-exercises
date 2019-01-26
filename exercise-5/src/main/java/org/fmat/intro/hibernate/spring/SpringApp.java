package org.fmat.intro.hibernate.spring;

import lombok.extern.slf4j.Slf4j;
import org.fmat.intro.hibernate.mapping.one2one.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@Configuration
@EnableJpaRepositories
@Slf4j
public class SpringApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SpringApp.class);

		DataStudentRepository repository = context.getBean(DataStudentRepository.class);

		repository.deleteAll();
		repository.save(Student
				.builder()
				.name("Juanita")
				.age(18)
				.build());
			log.info("Student {}" ,
					repository.findByNameAndAge("Juanita", 18)
							.orElseThrow(() -> new RuntimeException("Juanita NOT FOUND")));
	}
}

package org.fmat.intro.hibernate;

import java.util.Optional;
import java.util.Random;

import static org.fmat.intro.hibernate.HibernateUtil.*;

public class SchoolApp {

	public static void main(String[] args) {
		try{

			StudentRepository repository = new StudentRepository();
//			Student otherStudent = repository.save("Esau" , new Random().nextInt());
			Optional<Student> savedStudent = repository.byId(12);
//				Optional<Student> savedStudent = Optional.of(Student.builder().id(12).build());

//			savedStudent.setName("Maria");
//			savedStudent.ifPresent(a -> {
//				a.setAge(60);
//				repository.update(a);
//			}
//			);
			repository.findAllStudents().stream().forEach(System.out::println);


//			Optional<Student> optionalStudent = repository
//					.byId(12);
//
////			optionalStudent.ifPresent(a -> repository.delete(a));
//
//			System.out.println(optionalStudent
//					.map(a -> a.getName())
//					.orElse("SIN_NOMBRE"));

		}finally {
			shutdown();
		}
	}

}

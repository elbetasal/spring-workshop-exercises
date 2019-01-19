package org.fmat.intro.hibernate.mapping.one2one;

import org.fmat.intro.hibernate.BaseEntity;
import org.fmat.intro.hibernate.CrudRepository;

import java.util.Optional;

import static org.fmat.intro.hibernate.HibernateUtil.*;

public class SchoolApp {

	public static void main(String[] args) {
		try {
			CrudRepository repository = new CrudRepository();
			Student student = Student.builder().name("Esau").age(32).build();


			repository.save(student);
			BaseEntity retrievedStudent =  repository.byId(Student.class, student.getId());



			Address address = Address.builder()
					.address("Calle")
					.city("Merida")
					.student((Student) retrievedStudent)
					.zipCode(97217).build();

			repository.save(address , student.getId());

			address = repository.byId(retrievedStudent.getId());

			System.out.println(address);





		} finally {
			shutdown();
		}
	}

}

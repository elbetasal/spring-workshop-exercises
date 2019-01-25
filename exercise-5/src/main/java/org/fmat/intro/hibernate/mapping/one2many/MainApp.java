package org.fmat.intro.hibernate.mapping.one2many;

import org.fmat.intro.hibernate.CrudRepository;

import static org.fmat.intro.hibernate.HibernateUtil.*;

public class MainApp {

	public static void main(String[] args) {
		try{
			CrudRepository<Student> repository = new CrudRepository();
			Student student = Student.builder().age(45).name("Luis").build();
			student.getBooks().add(Book.builder().name("First Book").isbn("ISBN1200").build());
			repository.save(student);
		}finally {
			shutdown();
		}
	}
}

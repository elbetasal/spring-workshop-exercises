package org.fmat.intro.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;
import static org.fmat.intro.hibernate.HibernateUtil.*;

public class StudentRepository {

	public Student save(String name , Integer age){

		Session session = openSession();
		session.beginTransaction();

		Student newStudent = Student
				.builder()
				.age(age)
				.name(name)
				.build();
		session.persist(newStudent);

		session.getTransaction().commit();

		return newStudent;
	}

	public Optional<Student> byId(int id){
		Session session = openSession();
		return ofNullable(session.get(Student.class , id));
	}

	public void delete(Student student) {
		Session session = openSession();
		session.beginTransaction();

		session.delete(student);

		session.getTransaction().commit();
	}

	public void update(Student student) {
		Session session = openSession();
		session.beginTransaction();

		session.merge(student);

		session.getTransaction().commit();
	}

	public List<Student> findAllStudents() {
		Session session = openSession();

		Query query = session.createQuery(" from Student s");
		return query.getResultList();

	}
}

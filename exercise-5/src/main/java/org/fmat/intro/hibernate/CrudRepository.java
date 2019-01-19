package org.fmat.intro.hibernate;

import org.fmat.intro.hibernate.mapping.one2one.Address;
import org.fmat.intro.hibernate.mapping.one2one.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;
import static org.fmat.intro.hibernate.HibernateUtil.*;

public class CrudRepository<T extends BaseEntity> {

	public T save(T student){
		Session session = openSession();
		session.beginTransaction();

		session.persist(student);

		session.getTransaction().commit();
		session.close();
		return student;

	}

	public Address save(Address address, int studentId){
		Session session = openSession();

		session.beginTransaction();

		Student student = session.find(Student.class, studentId);
		address.setStudent(student);
		session.persist(address);

		session.getTransaction().commit();
		session.close();
		return address;

	}

	public Address byId(int id){
		Session session = openSession();
		Address optionalAddress = session.get(Address.class, id);
		session.close();
		return optionalAddress;
	}

	public T byId(Class<T> type ,int id){
		Session session = openSession();
		session.beginTransaction();
		T optionalStudent = session.get(type, id);
		session.getTransaction().commit();
		session.close();
		return optionalStudent;
	}


	public void delete(T student) {
		Session session = openSession();
		session.beginTransaction();
		session.delete(student);
		session.getTransaction().commit();
		session.close();
	}

	public void update(T student) {
		Session session = openSession();
		session.beginTransaction();
		session.merge(student);
		session.getTransaction().commit();
		session.close();
	}

	public List<T> findAllStudents() {
		Session session = openSession();
		Query query = session.createQuery(" from Student s");
		List resultList = query.getResultList();
		session.close();
		return resultList;

	}
}

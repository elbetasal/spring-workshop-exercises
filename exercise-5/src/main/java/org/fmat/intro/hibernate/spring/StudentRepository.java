package org.fmat.intro.hibernate.spring;

import org.fmat.intro.hibernate.mapping.one2one.Address;
import org.fmat.intro.hibernate.mapping.one2one.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(Student student){
		entityManager.persist(student);
	}

	public List<Student> findAllStudents() {
		return entityManager
				.createQuery("from Student")
				.getResultList();
	}

	@Transactional
	public void saveAddress(Student student, Address address) {
		entityManager.persist(student);
		address.setStudent(student);
		entityManager.persist(address);
	}

	@Transactional
	public void saveAddress(Address address) {
		Student student = entityManager.find(Student.class ,address.getStudent().getId());
		address.setStudent(student);
		entityManager.persist(address);
	}


}

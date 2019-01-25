package org.fmat.intro.hibernate.spring;

import org.fmat.intro.hibernate.mapping.one2one.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Repository
public class StudentRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(Student student){
		entityManager.persist(student);
	}

}

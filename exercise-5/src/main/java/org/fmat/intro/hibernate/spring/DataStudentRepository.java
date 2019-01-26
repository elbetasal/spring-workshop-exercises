package org.fmat.intro.hibernate.spring;

import org.fmat.intro.hibernate.mapping.one2one.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataStudentRepository extends PagingAndSortingRepository<Student , Integer> {

	Student findByName(String name);

	Optional<Student> findByNameAndAge(String name, int age);

	@Query("from Student s where s.name=:name")
	Student testQuery(@Param("name") String name);

}

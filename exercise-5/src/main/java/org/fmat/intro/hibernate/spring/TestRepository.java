package org.fmat.intro.hibernate.spring;

import org.fmat.intro.hibernate.mapping.one2one.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<Student , Integer> {
}

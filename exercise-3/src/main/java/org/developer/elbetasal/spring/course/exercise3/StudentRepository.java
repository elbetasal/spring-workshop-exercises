package org.developer.elbetasal.spring.course.exercise3;

import java.util.List;

public interface StudentRepository {

	Student create(String name , Integer age);

	Student findStudentById(Integer id);

	List<Student> findAllStudents();

	void delete(Integer id);

	void update(Integer id);
}

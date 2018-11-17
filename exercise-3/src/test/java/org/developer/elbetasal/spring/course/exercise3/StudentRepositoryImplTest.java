package org.developer.elbetasal.spring.course.exercise3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
public class StudentRepositoryImplTest {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void create() {
		Student student = this.studentRepository.create("Esau" , 34);
		assertThat(student , notNullValue());
		assertThat(student.getName() , is("Esau"));
		assertThat(student.getAge() , is(34));

		Student savedStudent = this.studentRepository.findStudentById(student.getId());

		assertThat(student , is(savedStudent));

	}

	@Test
	public void findStudentById() {
	}

	@Test
	public void findAllStudents() {
	}

	@Test
	public void delete() {
	}

	@Test
	public void update() {
	}
}
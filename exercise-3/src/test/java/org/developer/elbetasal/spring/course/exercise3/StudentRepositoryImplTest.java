package org.developer.elbetasal.spring.course.exercise3;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class StudentRepositoryImplTest {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void create() {

		Student student = this.studentRepository.create("Esau" , 34);

		assertThat(student , notNullValue());
		assertThat(student.getName() , is("Esau"));
		assertThat(student.getAge() , is(34));
		assertThat(getStudent(student), is(1));

	}

	@Test
	public void findAllStudents() {

		Number noOfRows = JdbcTestUtils.countRowsInTable(jdbcTemplate, "student");
		List<Student> students = studentRepository.findAllStudents();

		assertThat(students , hasSize(noOfRows.intValue()));

	}

	@Test
	public void delete() {

		final Student student = anyStudent();

		studentRepository.delete(student.getId());

		assertThat(getStudent(student) , is(0));

	}

	@Test
	public void update() {

		final Student student = anyStudent();
		student.setName("Test Update");
		student.setAge(9);

		studentRepository.update(student.getId() , student);
		Student updatedStudent = studentRepository.findStudentById(student.getId());

		assertStudent(student, updatedStudent);
	}

	@Test
	public void findStudentById() {

		Student anyStudent = anyStudent();
		Student retrievedStudent = studentRepository.findStudentById(anyStudent.getId());

		assertStudent(retrievedStudent , anyStudent);
	}

	private int getStudent(Student student) {

		return JdbcTestUtils.countRowsInTableWhere(jdbcTemplate , "student" ,
				"id="+student.getId());
	}

	private void assertStudent(Student student, Student updatedStudent) {

		assertThat(updatedStudent.getId() , is(student.getId()));
		assertThat(updatedStudent.getName() , is(student.getName()));
		assertThat(updatedStudent.getAge() , is(student.getAge()));

	}

	private Student anyStudent() {
		return studentRepository.findAllStudents()
				.stream()
				.findAny()
				.orElseThrow(() -> new RuntimeException("No students in the database"));
	}


}
package org.developer.elbetasal.spring.course.exercise3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class StudentRepositoryImplTest {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void create() {
		Student student = this.studentRepository.create("Esau" , 34);
		
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
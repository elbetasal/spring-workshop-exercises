package org.developer.elbetasal.spring.course.exercise3;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public StudentRepositoryImpl(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public Student create(String name, Integer age) {
		this.namedParameterJdbcTemplate.update(
				"insert into student name , age values(:name , :age)"
				, new MapSqlParameterSource("name" , name)
						.addValue("age" , age));
		return Student
				.builder()
				.age(age)
				.name(name)
				.build();
	}

	@Override
	public Student findStudentById(Integer id) {
		return null;
	}

	@Override
	public List<Student> findAllStudents() {
		return null;
	}

	@Override
	public void delete(Integer id) {

	}

	@Override
	public void update(Integer id) {

	}

}

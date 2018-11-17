package org.developer.elbetasal.spring.course.exercise3;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public StudentRepositoryImpl(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	@Transactional
	public Student create(String name, Integer age) {
		this.namedParameterJdbcTemplate.update(
				"insert into student (name , age) values (:name , :age)"
				, new MapSqlParameterSource("name" , name)
						.addValue("age" , age));

		long id = this.namedParameterJdbcTemplate
				.queryForObject("select id from student where name=:name and age=:age"
				,new MapSqlParameterSource("name" , name)
				.addValue("age" , age)
				, Long.class);
		return Student
				.builder()
				.age(age)
				.id(id)
				.name(name)
				.build();
	}

	@Override
	public Student findStudentById(Long id) {
		return this.namedParameterJdbcTemplate
				.queryForObject("select id , name , age from student where id=:id "
						, new MapSqlParameterSource("id", id)
						, (resultSet, i) -> Student
								.builder()
								.name(resultSet.getString("name"))
								.age(resultSet.getInt("age"))
								.id(resultSet.getLong("id"))
								.build());
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

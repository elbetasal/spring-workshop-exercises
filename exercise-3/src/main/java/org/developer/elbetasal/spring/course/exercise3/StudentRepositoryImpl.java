package org.developer.elbetasal.spring.course.exercise3;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


	private final DataSource dataSource;

	public StudentRepositoryImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

	}

	@Override
	@Transactional
	public Student create(String name, Integer age) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
				.withTableName("student")
				.usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", name);
		parameters.put("age", age);

		Number id = simpleJdbcInsert.executeAndReturnKey(parameters);
		return Student.builder()
				.id(id.longValue())
				.age(age)
				.name(name)
				.build();
	}

	@Override
	public Student findStudentById(Long id) {
		return this.namedParameterJdbcTemplate
				.queryForObject("select id , name , age from student where id=:id "
						, new MapSqlParameterSource("id", id)
						, this::toStudent);
	}

	@Override
	public List<Student> findAllStudents() {
		return this.namedParameterJdbcTemplate
				.query("select id , name , age from student" , new HashMap<>() , this::toStudent);
	}

	@Override
	public void delete(Long id) {
		this.namedParameterJdbcTemplate.update("delete from student where id=:id " ,
				new MapSqlParameterSource("id" , id));
	}

	@Override
	public void update(Long id, Student student) {
		this.namedParameterJdbcTemplate.update("update student set name=:name , age=:age where id=:id " ,
				new MapSqlParameterSource("id" , id)
						.addValue("name" , student.getName())
						.addValue("age" , student.getAge()));
	}

	private Student toStudent(ResultSet resultSet , int i) throws SQLException {
		return Student
				.builder()
				.name(resultSet.getString("name"))
				.age(resultSet.getInt("age"))
				.id(resultSet.getLong("id"))
				.build();
	}

}

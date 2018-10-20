package org.developer.elbetasal.spring.course.exercise3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

	private Integer age;
	private String name;
	private Integer id;

}

package org.fmat.intro.hibernate;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Data
@Builder
@Entity
@Table (name = "STUDENT")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Student {

	@Id
	@GeneratedValue(strategy = IDENTITY)
//	@Column(name = "id")
	private Integer id;

	@Column(name = "name" )
	private String name;

//	@Column(name = "age")
	private Integer age;



}

package org.fmat.intro.hibernate.mapping.one2many;

import lombok.*;
import org.fmat.intro.hibernate.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@Table (name = "STUDENT")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Student extends BaseEntity {

	@NotNull
	private String name;

	@NotNull
	private Integer age;

	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	@JoinColumn(name = "student_id")
	@Builder.Default
	private List<Book> books = new ArrayList<>();

}

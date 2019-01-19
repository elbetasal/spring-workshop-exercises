package org.fmat.intro.hibernate.mapping.one2one;

import lombok.*;
import org.fmat.intro.hibernate.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

}

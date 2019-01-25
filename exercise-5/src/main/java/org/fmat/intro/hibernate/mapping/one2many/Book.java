package org.fmat.intro.hibernate.mapping.one2many;

import lombok.*;
import org.fmat.intro.hibernate.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString(exclude = "student")
public class Book extends BaseEntity {

	private String name;

	private String isbn;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;

}

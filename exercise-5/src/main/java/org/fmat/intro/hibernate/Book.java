package org.fmat.intro.hibernate;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table( name = "BOOK")
@EqualsAndHashCode(of = "id")
@ToString
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String name;

	private String isbn;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
//	private Student student;

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Book{");
		sb.append("id='").append(id).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", isbn='").append(isbn).append('\'');
		sb.append('}');
		return sb.toString();
	}
}

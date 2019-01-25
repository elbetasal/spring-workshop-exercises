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
@NamedQueries(
		@NamedQuery(name = "studentById" , query = "from Student s join fetch s.books where s.id=:id")
)
public class Student extends BaseEntity {

	@NotNull
	private String name;

	@NotNull
	private Integer age;

	@OneToMany(
			mappedBy = "student",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	@Builder.Default
	private List<Book> books = new ArrayList<>();

	public void addBook(Book book) {
		books.add(book);
		book.setStudent(this);
	}

	public void removeBook(Book book) {
		books.remove(book);
		book.setStudent(null);
	}
}

package org.fmat.books;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

@Data
public class Book {

	private String id;

	@NotEmpty
	private String name;

	private String isbn;

	@PhoneNumberConstraint
	private String phone;

	@Email
	private String authorEmail;

	private Date publishedDate;

	private Boolean active = true;


	public Book() {
	}

	public Book(String id, String name, String isbn) {
		this.id = id;
		this.name = name;
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Book{");
		sb.append("id='").append(id).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", isbn='").append(isbn).append('\'');
		sb.append('}');
		return sb.toString();
	}
}

package org.fmat.books;

public class Book {

	private String id;

	private String name;

	private String isbn;

	public Book() {
	}

	public Book(String id, String name, String isbn) {
		this.id = id;
		this.name = name;
		this.isbn = isbn;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIsbn(String isbn) {
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

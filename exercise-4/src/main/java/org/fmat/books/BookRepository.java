package org.fmat.books;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class BookRepository {

	private List<Book> books = new ArrayList<>();

	@PostConstruct
	public void init() {
		books.add(new Book(UUID.randomUUID().toString(), "Harry Potter", "ISBN"));
		books.add(new Book(UUID.randomUUID().toString(), "Harry Potter 2", "ISBN 2"));
		books.add(new Book(UUID.randomUUID().toString(), "Harry Potter 3", "ISBN 3"));
		books.add(new Book(UUID.randomUUID().toString(), "Harry Potter 4", "ISBN 4"));
	}

	public List<Book> findAllBooks(){
		return books;
	}

	public Book saveBook(Book book) {
		Book savedBook = new Book(UUID.randomUUID().toString(),
				book.getName() , book.getIsbn());
		savedBook.setPhone(book.getPhone());
		savedBook.setAuthorEmail(book.getAuthorEmail());
		savedBook.setPublishedDate(book.getPublishedDate());
		savedBook.setActive(book.getActive());
		books.add(savedBook);
		return savedBook;
	}

	public Book findById(String bookId) {
		return books.stream()
				.filter(a -> a.getId().equalsIgnoreCase(bookId))
				.findFirst()
				.orElseThrow(() -> new BookNotFoundException());
	}

}

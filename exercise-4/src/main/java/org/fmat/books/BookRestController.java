package org.fmat.books;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {

	private BookRepository repository;

	public BookRestController(BookRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/{id}")
	public Book findByBookId(@PathVariable String id) {
		return repository.findById(id);
	}

	@GetMapping("/")
	public List<Book> findAllBook() {
		return repository.findAllBooks();
	}

	@GetMapping("/findByParam")
	public Book findAllBooksByParam(@RequestParam("id") String id ) {
		return repository.findById(id);
	}

	@PostMapping("/")
	public Book addBook(@RequestBody @Valid Book book) {
		return repository.saveBook(book);
	}

	@ExceptionHandler(BookNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleBookNotFoundException(HttpServletRequest request, Exception ex) {
		return "book not found";
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleAllExceptions(Exception ex){
		ex.printStackTrace();
		return "Something happend";
	}

}

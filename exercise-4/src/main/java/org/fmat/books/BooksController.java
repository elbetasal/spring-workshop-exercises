package org.fmat.books;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
@ControllerAdvice
@RequestMapping("/books-store")
public class BooksController {

	private final BookRepository bookRepository;

	public BooksController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping("/")
	public String defaultPage() {
		return "createBook";
	}

	@GetMapping("/show")
	public ModelAndView findBooks() {
		ModelAndView modelAndView = new ModelAndView("books_list",
				"books" , bookRepository.findAllBooks());
		return modelAndView;
	}

	@GetMapping("/showAddBook")
	public String showCreateBook(Model model){
		return "createBook";
	}

	@GetMapping("/bookDetails/{id}")
	public ModelAndView findBookById(@PathVariable String id,
	                                 @RequestParam("q") Optional<String> q){
		List books = new ArrayList();
		books.add(bookRepository.findById(id));
		ModelAndView modelAndView = new ModelAndView("books_list",
				"books" , books);
		LoggerFactory.getLogger(getClass()).info("El valor del param es {}"
				, q.orElse("No llego el parametro"));
		return modelAndView;
	}

	@PostMapping("/addNewBook")
	public String addBook(@ModelAttribute Book book ){
		bookRepository.saveBook(book);
		return "redirect:show";
	}

	@ModelAttribute
	public void addAt(Model model) {
		Book book = new Book(UUID.randomUUID().toString(),
				"Name","ISBN");
		model.addAttribute("book" , book);

	}
}

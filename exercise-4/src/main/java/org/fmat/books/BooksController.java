package org.fmat.books;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/booksMvc")
public class BooksController {

	private final BookRepository bookRepository;

	public BooksController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping("/show")
	public ModelAndView findBooks() {
		ModelAndView modelAndView = new ModelAndView("books" ,
				"books" , bookRepository.findAllBooks());
		return modelAndView;
	}


	@GetMapping("/{id}")
	public ModelAndView findBookById(@PathVariable String id,
	                                 @RequestParam("q") Optional<String> q){
		List books = new ArrayList();
		books.add(bookRepository.findById(id));
		ModelAndView modelAndView = new ModelAndView("books" ,
				"books" , books);
		LoggerFactory.getLogger(getClass()).info("El valor del param es {}"
				, q.orElse("No llego el parametro"));
		return modelAndView;
	}

	@GetMapping("/showAddBook")
	public String showCreateBook(Model model){
		Book book = new Book(UUID.randomUUID().toString(),
												"Name","ISBN");
		model.addAttribute("book" , book);
		return "createBook";
	}

	@PostMapping("/addBook")
	public String addBook(@ModelAttribute Book book ){
		bookRepository.saveBook(book);
		return "forward:show";
	}

}

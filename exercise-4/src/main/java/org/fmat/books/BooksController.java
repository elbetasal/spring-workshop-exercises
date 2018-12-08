package org.fmat.books;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

import static java.util.Arrays.*;

@Controller
@ControllerAdvice
@RequestMapping("/books-store")
public class BooksController {

	private final BookRepository bookRepository;

	public BooksController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@GetMapping("/")
	public String defaultPage(Model model , HttpSession session) {
		session.setAttribute("hello" , "Hello World");
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
	public String addBook(@Valid Book book ,
	                      BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "createBook";
		} else{
			bookRepository.saveBook(book);
			return "redirect:show";
		}

	}

	@ModelAttribute
	public void addAt(Model model) {
		Book book = new Book();
		model.addAttribute("book" , book);

	}

	@ModelAttribute("types")
	public List<BookType> types() {
		return asList(BookType.values());
	}


	public String getHello() {
		return "hello world from controller";
	}
}

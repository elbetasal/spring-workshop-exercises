package org.fmat.books;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/books")
public class BooksServlet extends HttpServlet {

	private BookRepository bookRepository = new BookRepository();

	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("books" , bookRepository.findAllBooks());
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/books_list.jsp");
		dispatcher.forward(request , response);
	}

}

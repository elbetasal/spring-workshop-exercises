package org.fmat.intro.hibernate.query;

import org.fmat.intro.hibernate.CrudRepository;
import org.fmat.intro.hibernate.HibernateUtil;

import static org.fmat.intro.hibernate.HibernateUtil.*;

public class MainApp {
	public static void main(String[] args) {
		try{
			CrudRepository repository = new CrudRepository();

			repository
					.findStudentsWithBooksById(7)
					.stream()
					.forEach(System.out::println);
		}finally {
			shutdown();
		}
	}
}

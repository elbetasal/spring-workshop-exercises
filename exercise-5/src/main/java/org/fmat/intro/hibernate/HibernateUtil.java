package org.fmat.intro.hibernate;

import org.fmat.intro.hibernate.mapping.one2many.Book;
import org.fmat.intro.hibernate.mapping.one2many.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure()
					.addAnnotatedClass(org.fmat.intro.hibernate.mapping.one2one.Student.class)
					.addAnnotatedClass(org.fmat.intro.hibernate.mapping.one2one.Address.class)
					.addAnnotatedClass(Student.class)
					.addAnnotatedClass(Book.class)
					.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	private static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}

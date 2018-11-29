package ch.interdiscount.bookstore.web.facades;

import ch.interdiscount.bookstore.repositories.BookRepository;
import ch.interdiscount.bookstore.web.controllers.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookstoreFacade {

	@Autowired
	private BookRepository bookRepository;

	public Book getBookById(final String id) {

		return Book.builder()
				.id(id)
				.build();
	}
}

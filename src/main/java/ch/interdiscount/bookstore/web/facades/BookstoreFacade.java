package ch.interdiscount.bookstore.web.facades;

import ch.interdiscount.bookstore.web.controllers.Book;
import org.springframework.stereotype.Service;


@Service
public class BookstoreFacade {

	public Book getBookById(final String id) {
		return Book.builder()
				.id(id)
				.build();
	}
}

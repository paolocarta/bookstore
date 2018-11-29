package ch.interdiscount.bookstore.web.controllers;

import ch.interdiscount.bookstore.web.facades.BookstoreFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/books")
public class BookstoreController {

	@Autowired
	private BookstoreFacade bookstoreFacade;

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable String isbn) {

		return bookstoreFacade.getBookById(isbn);
	}

	@GetMapping
	public List<Book> getAllBooks() {

		return Arrays.asList(
				getBook("2")
		);
	}

	private Book getBook(String id) {

		return Book.builder()
				.isbn(id)
				.build();
	}
}

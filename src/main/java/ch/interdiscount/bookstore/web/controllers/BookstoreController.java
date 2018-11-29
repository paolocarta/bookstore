package ch.interdiscount.bookstore.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/books")
public class BookstoreController {

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable  String id) {

		return Book.builder()
				.id(id)
				.build();
	}
}

package ch.interdiscount.bookstore.web.facades;

import ch.interdiscount.bookstore.repositories.BookEntity;
import ch.interdiscount.bookstore.repositories.BookRepository;
import ch.interdiscount.bookstore.web.controllers.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookstoreFacade {

	@Autowired
	private BookRepository bookRepository;

	public Book getBookById(final String id) {

		BookEntity bookEntity =
				bookRepository.findById(id)
						.orElse(getEmptyBook());

		return convertToBookDto(bookEntity);
	}

	private BookEntity getEmptyBook() {

		return BookEntity.builder().build();
	}

	private Book convertToBookDto(final BookEntity bookEntity) {

		return Book.builder()
				.isbn(bookEntity.getIsbn())
				.author(bookEntity.getAuthor())
				.title(bookEntity.getTitle())
				.build();
	}
}

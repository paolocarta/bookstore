package ch.interdiscount.bookstore.web.facades;

import ch.interdiscount.bookstore.repositories.BookEntity;
import ch.interdiscount.bookstore.repositories.BookRepository;
import ch.interdiscount.bookstore.web.controllers.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookstoreFacade {

	@Autowired
	private BookRepository bookRepository;

	public Book getBookById(final String isbn) {

		BookEntity bookEntity =
				bookRepository.findById(isbn)
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

	public List<Book> getAllBooks() {

		List<BookEntity> bookEntities = bookRepository.findAll();

		return bookEntities.stream()
				.map(this::convertToBookDto)
				.collect(Collectors.toList());
	}
}

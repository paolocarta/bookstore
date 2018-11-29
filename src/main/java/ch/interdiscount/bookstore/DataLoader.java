package ch.interdiscount.bookstore;

import ch.interdiscount.bookstore.repositories.BookEntity;
import ch.interdiscount.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(final ApplicationArguments args) throws Exception {
		bookRepository.save(
				BookEntity.builder()
						.author("paolo")
						.title("the best book")
						.isbn("1")
						.build()
		);
		bookRepository.save(
				BookEntity.builder()
						.author("matt")
						.title("the cool book")
						.isbn("2")
						.build()
		);
	}
}

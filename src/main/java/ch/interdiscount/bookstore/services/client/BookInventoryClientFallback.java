package ch.interdiscount.bookstore.services.client;

import org.springframework.stereotype.Component;


@Component
public class BookInventoryClientFallback implements BookInventoryClient{

	@Override
	public BookInventory getBookInventory(final String isbn) {

		return BookInventory.builder()
				.isbn(isbn)
				.quantity(0)
				.build();
	}
}

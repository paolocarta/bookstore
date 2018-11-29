package ch.interdiscount.bookstore.services.client;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class BookInventory {

	private String isbn;

	private int quantity;
}

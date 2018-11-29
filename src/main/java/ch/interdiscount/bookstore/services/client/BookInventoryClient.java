package ch.interdiscount.bookstore.services.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(
		name = "bookInventoryClient",
		url = "${bookstore.inventory.url}",
		fallback = BookInventoryClientFallback.class
)
public interface BookInventoryClient {

	@GetMapping(value = "/books/{isbn}")
	BookInventory getBookInventory(@PathVariable("isbn") String isbn);

}

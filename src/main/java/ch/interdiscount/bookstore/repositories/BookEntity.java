package ch.interdiscount.bookstore.repositories;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@Builder
public class BookEntity {

	@Id
	private String isbn;

	private String title;

	private String author;

}

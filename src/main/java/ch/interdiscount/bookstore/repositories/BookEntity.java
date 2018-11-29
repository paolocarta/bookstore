package ch.interdiscount.bookstore.repositories;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;

	private String title;

	private String author;

}

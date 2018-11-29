package ch.interdiscount.bookstore.web.controllers;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Book {

	private String id;
	private String title;
	private String author;

}

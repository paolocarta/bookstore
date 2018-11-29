package ch.interdiscount.bookstore.web.controllers;

import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookstoreControllerIT {

	@LocalServerPort
	private int port;

	@Before
	public void setUp() throws Exception {

		RestAssured.port = port;

	}

	@Test
	public void test_get_book_by_id() {

		Book book =
			RestAssured
					.given()
					.when()
					.get("/books/2")
					.then()
					.statusCode(HttpStatus.OK.value())
					.extract()
					.as(Book.class);

		assertThat(book.getId()).isEqualTo("2");
	}

	@Test
	public void test_get_all_books() {

	List<Book> books =
				RestAssured
						.given()
						.when()
						.get("/books")
						.then()
						.statusCode(HttpStatus.OK.value())
						.extract()
						.jsonPath().getList(".", Book.class);

	assertThat(books).isNotEmpty();


	}
}

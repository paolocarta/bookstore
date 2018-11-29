package ch.interdiscount.bookstore.web.controllers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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
	public void test_get_book_by_isbn() {

		Book book =
			RestAssured
					.given()
					.when()
						.get("/books/2")
					.then()
						.statusCode(HttpStatus.OK.value())
						.extract()
						.as(Book.class);

		assertThat(book.getIsbn()).isEqualTo("2");
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
		assertThat(books).hasSize(2);
	}

	@Test
	public void test_insert_book() {

		Book book = Book.builder()
				.isbn("3")
				.author("pat")
				.title("relational dbs")
				.build();

		RestAssured
				.given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(book)
				.when()
					.post("/books")
				.then()
					.statusCode(HttpStatus.CREATED.value());

	}
}

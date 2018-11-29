package ch.interdiscount.bookstore.web.controllers;

import ch.interdiscount.bookstore.web.facades.BookstoreFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@WebMvcTest(BookstoreController.class)
public class BookstoreControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookstoreFacade bookstoreFacade;

	@Test
	public void test_get_book_by_id() throws Exception {

		BDDMockito.given(
				bookstoreFacade.getBookById("2"))
				.willReturn(
						Book.builder()
								.isbn("2")
								.build()
				);

		mockMvc
				.perform(
					MockMvcRequestBuilders.get("/books/2")
						.accept(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$.isbn").value(2));

	}

	@Test
	public void test_get_all_books() throws Exception {

		mockMvc
				.perform(
					MockMvcRequestBuilders.get("/books")
					.accept(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());


	}
}

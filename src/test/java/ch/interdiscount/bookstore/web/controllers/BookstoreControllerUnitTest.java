package ch.interdiscount.bookstore.web.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@WebMvcTest
public class BookstoreControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test_get_book_by_id() throws Exception {

		mockMvc
				.perform(
					MockMvcRequestBuilders.get("/books/2")
				)
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());


	}
}

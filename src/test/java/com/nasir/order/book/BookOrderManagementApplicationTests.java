package com.nasir.order.book;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nasir.order.book.entity.Books;
import com.nasir.order.book.model.BookModel;
import com.nasir.order.book.model.BookType;
import com.nasir.order.book.serviceimpl.BookDaoServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
class BookOrderManagementApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private BookDaoServiceImpl daoServiceImpl;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void checkBookList() throws JsonProcessingException, Exception {
		BookModel bookModel = new BookModel(1, "testBook", "description book", "author", BookType.BOOK_TYPE_FICTION,
				100, "1-222-333-444-555", 0);
		mockMvc.perform(
				post("/saveBook").contentType("application/json").content(objectMapper.writeValueAsString(bookModel)))
				.andExpect(status().isOk());

		Books book = daoServiceImpl.findByBookname(bookModel.getBook());

		assert (book.getBook().equalsIgnoreCase(bookModel.getBook()));

	}

	@Test
	void checkoutBook() throws JsonProcessingException, Exception {
		BookModel bookModel = new BookModel(1, "testBook", "description book", "author", BookType.BOOK_TYPE_FICTION,
				100, "1-222-333-444-555", 10);

		List<BookModel> bookList = new ArrayList<>();
		bookList.add(bookModel);

		MvcResult mvcResult = mockMvc.perform(post("/checkoutBooks").contentType("application/json")
				.content(objectMapper.writeValueAsString(bookList))).andExpect(status().isOk()).andReturn();

		String discountResponse = mvcResult.getResponse().getContentAsString();
		assert ("90".equals(discountResponse));

	}
}

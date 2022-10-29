package com.nasir.order.book.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasir.order.book.entity.Books;
import com.nasir.order.book.serviceimpl.BookDaoServiceImpl;

@RestController
public class BookManagementController {

	BookDaoServiceImpl bookSservice;

	public BookManagementController(BookDaoServiceImpl bookSservice) {
		this.bookSservice = bookSservice;
	}

	@RequestMapping("/allBookList")
	public List<Books> getAllBookList() {
		return this.bookSservice.listAllBooks();
	}

	@PostMapping("/saveBook")
	public String saveBook(@RequestBody Books book) {
		try {
			this.bookSservice.saveBook(book);
		} catch (Exception e) {
			// TODO: handle exception
			return "Error found!!!";
		}
		return "Successfully saved!!!";
	}

	@PostMapping(value = { "/checkoutBooks", "/checkoutBooks/{discount}" })
	// ideally, discount should come with each book, but what I understood is that
	// we need to have extra param to handle it. Here we are considering the discount
	// param as general discount which will be applied to all books, once
	// calculation is done for each book
	public int checkoutBooks(@RequestBody List<Books> books, @PathVariable(required = false) Integer discount) {
		int totPriceAfterDiscount = 0;
		try {
			totPriceAfterDiscount = this.bookSservice.checkoutBooks(books, discount);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return totPriceAfterDiscount;
	}
}

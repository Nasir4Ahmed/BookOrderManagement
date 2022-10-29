package com.nasir.order.book.service;

import java.util.List;

import com.nasir.order.book.entity.Books;

public interface IBookDaoService {

	public List<Books> listAllBooks();
	public void saveBook(Books book);
	public Books findByBookname(String bookName);
	public int checkoutBooks(List<Books> books, Integer disount);
}

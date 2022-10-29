package com.nasir.order.book.model;

public class BookModel {
private int bookId;
private String book;
private String description;
private String author;
private String bookType;
private int price;
private String isbn;
private int discount;


public BookModel(int bookId, String book, String description, String author, String bookType, int price, String isbn,
		int discount) {
	super();
	this.bookId = bookId;
	this.book = book;
	this.description = description;
	this.author = author;
	this.bookType = bookType;
	this.price = price;
	this.isbn = isbn;
	this.discount = discount;
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getBook() {
	return book;
}
public void setBook(String book) {
	this.book = book;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getBookType() {
	return bookType;
}
public void setBookType(String bookType) {
	this.bookType = bookType;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}

}

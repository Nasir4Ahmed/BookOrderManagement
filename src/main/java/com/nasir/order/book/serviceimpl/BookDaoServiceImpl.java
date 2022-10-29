package com.nasir.order.book.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nasir.order.book.entity.Books;
import com.nasir.order.book.model.BookType;
import com.nasir.order.book.repository.BookRepository;
import com.nasir.order.book.service.IBookDaoService;

@Service
public class BookDaoServiceImpl implements IBookDaoService {

	private BookRepository bookRepo;

	public BookDaoServiceImpl(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Override
	public List<Books> listAllBooks() {
		// repository call to get data from DB
		List<Books> list = this.bookRepo.findAll();
		return list;
	}

	@Override
	public void saveBook(Books book) {
		this.bookRepo.save(book);

	}

	@Override
	public Books findByBookname(String bookName) {
		Books book = this.bookRepo.findAll().stream().filter(obj -> obj.getBook().equalsIgnoreCase(bookName))
				.findFirst().get();
		return book;
	}

	@Override
	public int checkoutBooks(List<Books> books, Integer discount) {
		int priceAfterDisount = 0;
		int discountedOffer = 0;

		for (Books book : books) {
			// this switch block will not be required if we pass the discount for each book
			switch (book.getBookType()) {
			case BookType.BOOK_TYPE_FICTION:
				discountedOffer = book.getDiscount();
				break;
			case BookType.BOOK_TYPE_CLASSICAL:
				discountedOffer = book.getDiscount();
				break;
			case BookType.BOOK_TYPE_FANTASY:
				discountedOffer = book.getDiscount();
				break;
			case BookType.BOOK_TYPE_HORROR:
				discountedOffer = book.getDiscount();
				break;
			default:
				discountedOffer = 0;
			}
			
			int price =book.getPrice();
			priceAfterDisount += price - (price*discountedOffer/100);
		}
		// check if discount param is available, then we need to vie promotional extra discount
		if(discount!=null && discount >0) {
			priceAfterDisount = priceAfterDisount - (priceAfterDisount*discount/100);
		}
		return priceAfterDisount;
	}

}

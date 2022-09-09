package in.malonus.springboot.rest.demo.app.service;

import java.util.List;

import in.malonus.springboot.rest.demo.app.model.Book;

public interface BookService {

	Book saveBook(Book Book);

	List<Book> fetchBookList();

	Book updateBook(Book Book, String BookId);

	void deleteBookById(String BookId);

	Book findBookById(String bookId);
}

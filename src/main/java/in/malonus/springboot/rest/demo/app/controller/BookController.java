package in.malonus.springboot.rest.demo.app.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.malonus.springboot.rest.demo.app.model.Book;
import in.malonus.springboot.rest.demo.app.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createBook(@RequestBody Map<String, Object> bookMap) {
		Book book = new Book(bookMap.get("name").toString(), bookMap.get("isbn").toString(),
				bookMap.get("author").toString(), Integer.parseInt(bookMap.get("pages").toString()));

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Book created successfully");
		response.put("book", bookService.saveBook(book));
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
	public Book getBookDetails(@PathVariable("bookId") String bookId) {
		return bookService.findBookById(bookId);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{bookId}")
	public Map<String, Object> editBook(@PathVariable("bookId") String bookId,
			@RequestBody Map<String, Object> bookMap) {
		Book book = new Book(bookMap.get("name").toString(), bookMap.get("isbn").toString(),
				bookMap.get("author").toString(), Integer.parseInt(bookMap.get("pages").toString()));
		book.setId(bookId);

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Book Updated successfully");
		response.put("book", bookService.saveBook(book));
		return response;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{bookId}")
	public Map<String, String> deleteBook(@PathVariable("bookId") String bookId) {
		bookService.deleteBookById(bookId);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Book deleted successfully");

		return response;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> getAllBooks() {
		List<Book> books = bookService.fetchBookList();
		System.out.println("the books are:" + books);
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("totalBooks", books.size());
		response.put("books", books);
		return response;
	}
}

package in.malonus.springboot.rest.demo.app.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Book {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String name;
	private String isbn;
	private String author;
	private int pages;

	public Book() {
	}

	public Book(String name, String isbn, String author, int pages) {
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.pages = pages;
	}

	@PrePersist
	private void ensureId() {
		this.setId(UUID.randomUUID().toString());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

}

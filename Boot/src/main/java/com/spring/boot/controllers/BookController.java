package com.spring.boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.entities.Book;
import com.spring.boot.services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

//	Get All Books
	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.bookService.getAllBooks();
	}

//	Get Single Book
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}

//	Add New Book
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b = this.bookService.addBook(book);
		return b;
	}
	
//	Delete Book
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable("id") int id)
	{
		this.bookService.deleteBook(id);
	}
	
//	Update Book
	@PutMapping("/book/{id}")
	public Book updateBook(@RequestBody Book book ,@PathVariable("id") int id)
	{
		this.bookService.updateBook(book, id);
		return book;
	}
}

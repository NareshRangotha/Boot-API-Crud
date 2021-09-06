package com.spring.boot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.spring.boot.entities.Book;

@Component
public class BookService {

	private static List<Book> list = new ArrayList<>();

	static {
		list.add(new Book(1, "Java", "XYZ"));
		list.add(new Book(2, "Python", "ABC"));
		list.add(new Book(3, "C", "DEF"));
		list.add(new Book(4, "Rract", "GHI"));
	}

//	get all books
	public List<Book> getAllBooks() {
		return list;
	}

//	get single book by id
	public Book getBookById(int id) {
		Book book = null;
		book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		return book;
	}

//	Adding the book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}

//	Delete Book
	public void deleteBook(int id) {
		list = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
	}
	
//	Update Book
	public void updateBook(Book book, int id)
	{
		list=list.stream().map(b->{
			if(b.getId()==id)
			{
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}

}

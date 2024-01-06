package com.api.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepo;
import com.api.book.entities.Book;

@Component
public class BookService {
	@Autowired
	private BookRepo bookRepo;


	// get all books

	public List<Book> getAllBooks() {
		List<Book> list=(List<Book>)this.bookRepo.findAll();
		return list;
	}

	// get single book by id

	public Book getBookById(int id) {
		Book book = null;
		try {

//			book = list.stream().filter(e -> e.getId() == id).findFirst().get();
			book= this.bookRepo.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// Adding the Book
	public Book addBook(Book b) {
//		list.add(b);
		Book result=bookRepo.save(b);
		
		return result;
	}

	// delete book

	public void deleteBook(int bid) {
//		list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
		bookRepo.deleteById(bid);
	}



	// update a book
	public void updateBook(Book book, int bookId) {
		
		book.setId(bookId);
		bookRepo.save(book);
		

	}

}

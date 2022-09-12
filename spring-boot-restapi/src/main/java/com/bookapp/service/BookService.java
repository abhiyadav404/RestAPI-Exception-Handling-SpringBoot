package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.models.Book;

public interface BookService {
	void addBook(Book book);
Book getById(int bookId)throws IdNotFoundException;
List<Book> getBooksByAuthor(String author)throws BookNotFoundException;
List<Book> getBooksByCategory(String category)throws BookNotFoundException;
}

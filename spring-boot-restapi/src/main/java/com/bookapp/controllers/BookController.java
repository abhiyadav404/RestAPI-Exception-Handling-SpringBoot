package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.models.Book;
import com.bookapp.service.BookService;

@RestController
@RequestMapping("book-restapi")
public class BookController {
	@Autowired
	BookService bookservice;
	@GetMapping("/greet")
	
   public ResponseEntity<String> sayHello() {
	   String msg="Welcome to Book App";
	   HttpHeaders header=new HttpHeaders();
	   header.add("desc", msg);
	   return new ResponseEntity<String>(msg, header, HttpStatus.OK);
   }
	@PostMapping("/books")
	public ResponseEntity<Void> addBook(@RequestBody Book book)
	{
		bookservice.addBook(book);
		HttpHeaders header=new HttpHeaders();
	    header.add("desc", "One book Added");
	    return ResponseEntity.status(HttpStatus.OK).headers(header).build();
	}
	@GetMapping("/books-by-id/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id")int bookId)
	{
		 Book book= bookservice.getById(bookId);
		 HttpHeaders header=new HttpHeaders();
		 header.add("desc", "Getting book by Id");
		 return ResponseEntity.status(HttpStatus.OK).headers(header).body(book);
	}
	
	@GetMapping("/books-by-author/{Author}")
	public ResponseEntity<List<Book>> getBookByAuthor(@PathVariable String Author)
	{
		List<Book>bookList=bookservice.getBooksByAuthor(Author);
		return ResponseEntity.ok(bookList);
	}
	
	@GetMapping("/books-by-category")
	public ResponseEntity<List<Book>> getBookByCategory(@RequestParam("category")String category)
	{
		HttpHeaders header=new HttpHeaders();
		header.add("desc", "list of books by Category");
		header.add("Type", "book Object");
		List<Book>bookList=bookservice.getBooksByCategory(category);
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(bookList);
	}
}

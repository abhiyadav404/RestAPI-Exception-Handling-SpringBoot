package com.bookapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.models.Book;
@Service
public class BookServiceImpl implements BookService {

	@Override
	public Book getById(int bookId) {
		if(bookId<=0)
		{
			throw new RuntimeException("Other Type of Exception");
		}
		return getBookList()
				.stream()
				.filter((book)->book.getBookId()==bookId)
				.findAny()
				.orElseThrow(()-> new IdNotFoundException("Invalid ID"));			
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		// TODO Auto-generated method stub
		List<Book>bookList= getBookList()
				.stream()
				.filter((book)->book.getAuthor().equals(author))
				.collect(Collectors.toList());
	    if(bookList.isEmpty())
	    {
	    	throw new BookNotFoundException("Book with this author isn't available");
	    }
	    return bookList;
	
	}

	@Override
	public List<Book> getBooksByCategory(String category) {
		// TODO Auto-generated method stub
		List<Book>bookList=getBookList()
				.stream()
				.filter((book)->book.getCategory().equals(category))
				.collect(Collectors.toList());
		 if(bookList.isEmpty())
		    {
		    	throw new BookNotFoundException("Book with this category isn't available");
		    }
		    return bookList;
	}
	
	private List<Book>getBookList(){
		return Arrays.asList(new Book("Java","kathy","Tech",10),
				new Book("Spring","rod","Tech",11),
				new Book("Miracle","robin","Fiction",12),
				new Book("Ferrari","robin","Fiction",13),
				new Book("Captain","hall","Comic",14),
				new Book("Morning Misty","hall","horror",15));
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		System.out.println(book);
		
		
	}
}

package com.bookapp.exception;

public class BookNotFoundException extends RuntimeException {
       private static final long serialVersionUID=1L;
       
       public BookNotFoundException()
       {
    	   super();
       }
       
       public BookNotFoundException(String arg0)
       {
    	   super(arg0);
       }
}

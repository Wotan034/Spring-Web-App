package com.Experiment.Spring5webapp2.service;

import java.util.List;
import java.util.Set;

import com.Experiment.Spring5webapp2.domain.Author;
import com.Experiment.Spring5webapp2.domain.Book;

public interface BookService {

	
	List<Book> getAllBooks();
	
	List<Book> getAllBooksByAuthors(Set<Author> author);
	
	List<Book> getAllBooksByAuthorsWithLastnameInitial(char lastNameInitial);
	
}

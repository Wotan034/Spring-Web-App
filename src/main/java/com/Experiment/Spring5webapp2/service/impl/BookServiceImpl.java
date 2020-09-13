package com.Experiment.Spring5webapp2.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Experiment.Spring5webapp2.Repositories.BookRepository;
import com.Experiment.Spring5webapp2.domain.Author;
import com.Experiment.Spring5webapp2.domain.Book;
import com.Experiment.Spring5webapp2.service.AuthorService;
import com.Experiment.Spring5webapp2.service.BookService;


@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private AuthorService authorService;

	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public List<Book> getAllBooksByAuthors(Set<Author> authors) {
		
		List<Book> ret = bookRepo.findAllByAuthorsIn(authors);
		
		System.out.println("all books " + ret.size());
		
		return ret;
	}

	@Override
	public List<Book> getAllBooksByAuthorsWithLastnameInitial(char lastNameInitial) {
		
		System.out.println("checking lat name initial of " + lastNameInitial);
		
		List<Book> ret = new ArrayList<Book>();
		List<Author> allAuthors = authorService.getAllAuthors();
		System.out.println("all authors size =  " + allAuthors.size());
		List<Author> relevantAuthors = new ArrayList<>();
		for (Author author : allAuthors) {
			
			System.out.println("checking  author " + author.getFirstName() + " " + author.getLastName());
			
			if(Character.compare(Character.toLowerCase(lastNameInitial), Character.toLowerCase(author.getLastName().charAt(0))) == 0 ) {
				
				System.out.println("adding relevant author " + author.getFirstName() + " " + author.getLastName());
				
				relevantAuthors.add(author);
			}
		}
		for (Author author : relevantAuthors) {
			Set<Author> authors = new HashSet<Author>();
			authors.add(author);
			ret.addAll(this.getAllBooksByAuthors(authors));
		}
		
		return ret;
	}
	
	
	
}

package com.Experiment.Spring5webapp2.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Experiment.Spring5webapp2.Repositories.BookRepository;
import com.Experiment.Spring5webapp2.domain.Book;
import com.Experiment.Spring5webapp2.service.BookService;

@Controller
public class BookController {

    private final BookRepository bookRepository;
    
    @Autowired
    private BookService bookService;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    
    
    
    /**
     * base method calls for all books, but appending ?authorLastNameFirstCharacter={lastNameInitial}
     * tells the controller to search off of the lastName initial of the author and display only those books.
     * 
     * ex: ?authorLastNameFirstCharacter=e
     * will return a list one one book : Domain Driven Design
     * 
     * @param model
     * @param lastNameInitial 
     * @return
     */
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getBooks(Model model, @RequestParam(name = "authorLastNameFirstCharacter", required = false) String lastNameInitial){

    	List<Book> booksForDisplay = null;
    	
    	if(lastNameInitial == null) {
    		booksForDisplay = bookService.getAllBooks();
    		
    	} else {
    		
    		booksForDisplay = bookService.getAllBooksByAuthorsWithLastnameInitial(lastNameInitial.charAt(0));
    		
    	}
    	
    	
        model.addAttribute("books", booksForDisplay);

        return "books/list";
    }
    
    
    
    
}

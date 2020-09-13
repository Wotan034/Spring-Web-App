package com.Experiment.Spring5webapp2.Repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Experiment.Spring5webapp2.domain.Author;
import com.Experiment.Spring5webapp2.domain.Book;

public interface BookRepository extends JpaRepository <Book, Long> {


	List<Book> findAllByAuthorsIn(Set<Author> authors);

}

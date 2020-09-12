package com.Experiment.Spring5webapp2.Repositories;

import com.Experiment.Spring5webapp2.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, Long> {
}

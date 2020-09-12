package com.Experiment.Spring5webapp2.Repositories;

import com.Experiment.Spring5webapp2.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

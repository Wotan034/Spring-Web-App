package com.Experiment.Spring5webapp2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Experiment.Spring5webapp2.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

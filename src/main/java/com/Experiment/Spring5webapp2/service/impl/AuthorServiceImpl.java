package com.Experiment.Spring5webapp2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Experiment.Spring5webapp2.Repositories.AuthorRepository;
import com.Experiment.Spring5webapp2.domain.Author;
import com.Experiment.Spring5webapp2.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepository authorRepo;
	
	@Override
	public List<Author> getAllAuthors(){
		return authorRepo.findAll();
	}
	
}

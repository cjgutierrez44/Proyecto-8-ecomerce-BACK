package com.tig.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tig.ecomerce.model.Comment;
import com.tig.ecomerce.repository.CommentRepository;

@Service
public class CommentServiceImplementation implements CommentService{
	
	@Autowired
	private CommentRepository repository;
	
	@Override
	public Comment saveComment(Comment comment) {
		return repository.save(comment);
	}

}

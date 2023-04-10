package com.tig.ecomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tig.ecomerce.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    @Query("SELECT c FROM Comment c")
    List<Comment> findAll();
}

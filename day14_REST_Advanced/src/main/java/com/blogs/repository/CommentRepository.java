package com.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.entities.Comment;
//
///public class CommentRepository extends JpaRepository<Comment, Long> {
//
//}
public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	
}
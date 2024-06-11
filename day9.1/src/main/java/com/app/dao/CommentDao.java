package com.app.dao;

import com.app.entities.Comment;

public interface CommentDao {
	String AddComment(Comment comment,Long commenterId,Long postId); 

}

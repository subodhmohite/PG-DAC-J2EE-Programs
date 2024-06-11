package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.CommentDaoImpl;
import com.app.entities.Comment;

public class AddComment {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// create post dao instance
			CommentDaoImpl commentDao = new CommentDaoImpl();
			// for testing - do not add any white space
			System.out.println("Enter Comment,rating, commenterId, postId");
			Comment comment = new Comment(sc.nextLine(),sc.nextInt());
			System.out.println(commentDao.AddComment(comment,sc.nextLong(),sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}

}

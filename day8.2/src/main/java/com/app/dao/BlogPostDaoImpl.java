package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entities.BlogPost;
import com.app.entities.Category;
import com.app.entities.User;

public class BlogPostDaoImpl implements BlogPostDao {

	@Override
	public String createNewBlog(BlogPost post, Long categoryid, Long autorId) {
		String mesg="Post not added";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();

		// L1 cache is created -- EMPTY
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();

		try {
			//get category id 
			Category cat=session.get(Category.class, categoryid);
			//get author id
			User author=session.get(User.class, autorId);
			//null checKing--if not null 
			if(cat!=null && author!=null) {
			//establish asso between post and author & post and  category
			//setter
				post.setChosenCategory(cat);
				post.setAuthor(author);
			}
			//since no cascading yet -- explicitly persist post.
			session.persist(post);
			mesg="Added a new post with id"+post.getId();
			
			tx.commit();
			
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}

		return mesg;
	
	}

}

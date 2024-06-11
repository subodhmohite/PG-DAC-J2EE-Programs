package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entities.BlogPost;
import com.app.entities.Comment;
import com.app.entities.User;

public class CommentDaoImpl implements CommentDao {

	@Override
	public String AddComment(Comment comment,Long commenterId,Long postId) {
		String mesg = "Comments Added failed !!!!";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();

		// L1 cache is created -- EMPTY
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();

		try {
			User user=session.get(User.class,commenterId);
			BlogPost post=session.get(BlogPost.class, postId);
			if(user!=null && post!=null && commenterId!=post.getAuthor().getId())
			{
				//user n post -persistent
				//establish uni dir asso comment--> user
				comment.setCommenter(user);
				//comment-->post
				comment.setPost(post);
		// 3. Session API -- public void persist(Object o) throws HibExc
			session.persist(comment); // user : persistent
			// rec will be inserted in db
			mesg = "Comments Added successfully , with ID =  " + comment.getId();
			}
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

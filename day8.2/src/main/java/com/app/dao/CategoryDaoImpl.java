package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entities.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public String AddCategory(Category category) {
		String mesg = "Registration failed !!!!";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();

		// L1 cache is created -- EMPTY
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();

		try {
			// 3. Session API -- public void persist(Object o) throws HibExc
			session.persist(category); // user : persistent
			tx.commit();
			// rec will be inserted in db
			mesg = "Category added successfully , with ID =  " + category.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}

		
		return mesg;
	}
	
	}



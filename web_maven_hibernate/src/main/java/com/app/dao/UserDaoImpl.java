package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entities.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User signIn(String email, String password)  {
		User user=null;
		String jpql="select u from User u where email=:em and password=:pass";
		// 1. get session from SF (get curnt session)
				Session session = getFactory().getCurrentSession();
				// 2. begin a tx
				Transaction tx = session.beginTransaction();
				try {
					user = session.createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", password)
							.getSingleResult();
					tx.commit();
				} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback();
					// re throw the exception to the caller
					throw e;
				}

				return user;
			}
	
	}
	

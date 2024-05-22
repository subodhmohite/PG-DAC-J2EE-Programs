package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entities.Role;
import com.app.entities.User;

public class UserDaoImpl implements UserDao {

	
	@Override
	public String registerUser(User user) {
		// user : transient(neither associated with L1 cache nor in DB)
		String mesg = "Registration failed !!!!";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		Session session2 = getFactory().getCurrentSession();// db cn is pooled out n
		System.out.println(session == session2);// t
		// L1 cache is created -- EMPTY
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		System.out.println("session is open " + session.isOpen() + " is conncted " + session.isConnected());// t t

		try {
			// 3. Session API -- public Serializable save(Object o) throws HibExc
			Serializable userId = session.save(user);
			/*
			 * Hibernate adds transient entity ref to L1 cache user : PERSISTENT (part of L1
			 * cache , BUT not yet part of DB)
			 */
			System.out.println("Id class " + userId.getClass());
			tx.commit();
			System.out.println("session is open " + session.isOpen() + " is conncted " + session.isConnected());// f f

			/*
			 * Hibernate performs 1. session.flush() --> hib does auto dirty
			 * checking(=checking the state of L1 cache against DB) performs DML -- insert
			 * Persistent entites (transient -> persistent : save | persist |saveOrUpdate |
			 * merge will gain DB identity, upon commmit session.close(); -L1 cache is
			 * destroyed n pooled out db cn rets to the DBCP
			 */
			// rec will be inserted in db
			mesg = "User registered successfully , with ID =  " + userId;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		System.out.println("session is open " + session.isOpen() + " is conncted " + session.isConnected());// f f

		// user - DETACHED (doesn't exist in L1 cache , BUT has DB identity)
		return mesg;
	}

	@Override
	public User getUserDetails(Long userId) {
		User user=null;//user - does not exist (in the java heap n not in L1 cache)
		// 1. get session from SF (getCurrentSession)
		Session session=getFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			//3. get user details by it's id
			user=session.get(User.class, userId);//select * from users where id=?
			user=session.get(User.class, userId);
			user=session.get(User.class, userId);
			user=session.get(User.class, userId);
			//user - null (id doesn't exist) OR in case of valid id -- 
			//PERSISTENT (part of L1 cache , does have db identity)
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			//re throw the exc to the caller
			throw e;
		}
		return user;//user - DETACHED | doesn 't exist
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users=null;
		String jpql="select u from User u";
		//1.get session from SF (get curnt session)
		Session session=getFactory().getCurrentSession();
		//2.begin tx
		Transaction tx=session.beginTransaction();
		try {
			//3.Create query object n execute the same
			/*Session API 
			public Query<T> createQuery(String hql,jpql,Class<T> class)throws HibernateException
			Query API to execute Query
			List<T> getResultList();
			*/
			users=session.createQuery(jpql,User.class)
					.getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			//re throw the exception to the caller
			throw e;
		}
	return users;
	}
	
	@Override
	public List<User> getUsersByDobAndRole(LocalDate start,LocalDate end1,Role role) {
		List<User> users=null;
		String jpql="select u from User u where u.dob between :start and :end and u.role=:rl";
		//1.get session from SF (get curnt session)
		Session session=getFactory().getCurrentSession();
		//2.begin tx
		Transaction tx=session.beginTransaction();
		try {
			
			users=session.createQuery(jpql,User.class)//query Object
					.setParameter("start", start)
					.setParameter("end", end1)
					.setParameter("rl", role)
					.getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			//re throw the exception to the caller
			throw e;
		}
	return users;
		
	
	}

	

}

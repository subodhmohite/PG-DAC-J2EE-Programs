package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;

public class GetUserDetails2 {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create user dao instance
			UserDao userDao = new UserDaoImpl();
			userDao.getAllUsers().forEach(System.out::println);
		} // JVM sf.close() => cleaning up of DBCP
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

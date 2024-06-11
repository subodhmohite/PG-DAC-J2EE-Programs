package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.CategoryDaoImpl;
import com.app.entities.Category;

public class AddCategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)) {
			//create user dao instance
			CategoryDaoImpl categoryDao=new CategoryDaoImpl();
			System.out
					.println("Enter user details -name and Details");
			Category category = new Category(sc.next(), sc.nextLine());
			
			System.out.println(categoryDao.AddCategory(category));
		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}

}

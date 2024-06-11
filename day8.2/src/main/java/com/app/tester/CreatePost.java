package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.BlogPostDaoImpl;
import com.app.entities.BlogPost;

public class CreatePost {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)) {
		
			 BlogPostDaoImpl blogpostDao=new BlogPostDaoImpl();
			System.out
					.println("Enter post details");
			BlogPost blogpost = new BlogPost(sc.nextLine(),sc.nextLine(),sc.nextLine());
			
			System.out.println(blogpostDao.createNewBlog(blogpost, sc.nextLong(), sc.nextLong()));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

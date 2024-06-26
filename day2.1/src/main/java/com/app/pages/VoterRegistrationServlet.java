package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.UserDao;
import com.app.dao.UserDaoImpl;
import com.app.entities.User;



@WebServlet("/voter_register")
public class VoterRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	@Override
	public void init() throws ServletException{
		System.out.println("in init of"+getClass());
		try {
			 userDao= new UserDaoImpl();
		} catch (Exception e) {
			throw new ServletException("err in init"+getClass(),e);
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void destroy() {
		try {
			// WC invokes it once @ end of the life cycle
			// clean up Dao
			System.out.println("in destroy");
			userDao.cleanUp();
		} catch (Exception e) {
			System.out.println("err in destroy - " + getClass());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set content type
		response.setContentType("text/html");
		//get Printwriter
		try(PrintWriter pw=response.getWriter()){
			HttpSession session =request.getSession();
			
			String fisrtname=request.getParameter("fn");
			String lastname=request.getParameter("ln");
			String email=request.getParameter("em");
			String password=request.getParameter("pass");
		    LocalDate dob=LocalDate.parse(request.getParameter("dob"));
		    int age=Period.between(dob,LocalDate.now()).getYears();
		    if(age >= 21) {
		    	//create voter instance 
		    	User user=new User(fisrtname,lastname,email,password,Date.valueOf(dob));
		    	//assign the role as voter
		    	user.setRole("voter");
		    	//invoke user dao's method for inserting voter details
		    
					String regStatus = userDao.voterRegistration(user);
					pw.print("<h5>"+regStatus+"</h5>");
				
		    }
		    else {
		    	pw.print("<h5>proceed to<a href='login.html'>Login</a></h5>");
		    }
		}
		    catch(Exception e) {
		    	throw new ServletException("err in doPost"+getClass(),e);
		    }
		    		    
		   
		}
	}



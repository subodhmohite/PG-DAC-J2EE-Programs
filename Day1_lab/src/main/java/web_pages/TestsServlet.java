package web_pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestsServlet
 */
@WebServlet("/hello")
/* runtime,class level,mandatory annotation meant for WC 
 * When you deploy a web app ,WC creates a Map
 * key -- url pattern
 * value -- F>Q servlet class name(web_pages.TestServlet)
 * URL --http://host:port/Day1_lab/hello
 * http -- app layer protocol(scheme)
 * host -- DNS qualified host name (www.abc.com) OR IP addres
 * port -- TCP port no(default port-8080)
 * URI -- /Day1_lab/hello
 * /Day1_lab-- context(=web app)root
 *(/hello)--URl pattern
 * */


public class TestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("in init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.set response content type 
		response.setContentType("text/html");
		//2.get the PW from HttpServletResponse  to send buffered-->to the client
		try(PrintWriter pw=response.getWriter()){
			//add dyn contents to PW's buffer
			pw.print("<h4>Hello from Servlets.."+LocalDateTime.now()+"</h4>");
		}
	}

}
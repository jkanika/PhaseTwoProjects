package loginValidation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Sent content type of this page
		response.setContentType("text/html");
				
		//Invalidating the session
		request.getSession().invalidate();
		
		//Redirecting the page back to index.html
		//response.sendRedirect("index.html");
		
		response.getWriter().println("<center> <span style ='color :red'> <h3>You have been successfully logged out! </center> </span> </h3>");
		//Request Dispatcher used for redirect
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		
		dispatcher.include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}

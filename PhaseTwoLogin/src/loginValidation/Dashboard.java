package loginValidation;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Sent content type of this page
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		response.getWriter().println("<center><h2>Welcome "+session.getAttribute("usName")+ "</h2> </center>");
		response.getWriter().println("<center><h2>Login at : "+new Date()+ "</h2> </center>");
		response.getWriter().println("<br> <center> <form action='Logout' method='post'> <input type='submit' value='Logout'/>"+"</form></center>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}

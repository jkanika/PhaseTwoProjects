package loginValidation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Sent content type of this page
		response.setContentType("text/html");
		
		//Get writer reference
		PrintWriter out = response.getWriter();
		
		//Get a reference to session object
		HttpSession session = request.getSession();
		
		//Get the parameters from first.html
		String name = request.getParameter("uName");
		String pswd = request.getParameter("password");
		
		//out.println("<h1> Welcome" + name +"</h1>");
		
		if(name.trim().equals("Kanika") && pswd.trim().equals("kan123")) {
			//Putting username into the session
			session.setAttribute("usName", name);
			
			//Redirect to Dashboard
			response.sendRedirect("Dashboard");
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
			response.getWriter().println("<center> <span style ='color :red'> <h3>Invalid Credentials! </span> </center></h3>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
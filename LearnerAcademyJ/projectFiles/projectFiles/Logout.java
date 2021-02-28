package projectFiles;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Sent content type of this page
			response.setContentType("text/html");
					
			//Invalidating the session
			request.getSession().invalidate();
						
			response.getWriter().println("<center> <span style='text-align:center'> <h3 style ='color :red'>You have been successfully logged out! </center> </span> </h3>");
			//Request Dispatcher used for redirect
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			
			dispatcher.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

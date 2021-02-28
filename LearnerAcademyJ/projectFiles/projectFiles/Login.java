package projectFiles;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		//Get a reference to session object
		HttpSession session = request.getSession();
		
		//Get the parameters from index.jsp
		String email = request.getParameter("adminMail");
		String pswd = request.getParameter("adminPass");
		
		try {
			

			DBConnection conn = new DBConnection();
			
			Connection dbCon = conn.getConnection();
			//Query
			String qry = "select * from admin a where a.admin_email =? and a.admin_pass =?";
			//Prepared Statement
			PreparedStatement stmt = dbCon.prepareStatement(qry);
			
			
			// Set the parameters got from the app
            stmt.setString(1, email);
            stmt.setString(2, pswd);
            

            
            ResultSet rs =  stmt.executeQuery();
    		if(rs.first()) {

	    			String name = rs.getString(2);
	    			session.setAttribute("adminName", name);
	    			response.sendRedirect("ClassInfo.jsp");
	    			
    		} else {
    			response.getWriter().println("<span style ='text-align:center;'> <h3 style = 'color:red'>Invalid Credentials! </span> </style> </h3>");
    			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    			dispatcher.include(request, response);
    		}

			stmt.close();

			out.println("</body></html>");
			conn.closeConnection();

		} catch (ClassNotFoundException e) {
			out.println("Class not found exception");
			out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			out.println("SQL not found exception");
			out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

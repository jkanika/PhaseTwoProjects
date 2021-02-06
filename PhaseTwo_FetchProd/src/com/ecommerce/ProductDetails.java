package com.ecommerce;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		try {
			

			//InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			//Properties props = new Properties();
			//props.load(in);

			DBConnection conn = new DBConnection();
			
			Connection dbCon = conn.getConnection();
			//Query
			String qry = "select * from eproduct where prod_id =?";
			//Prepared Statement
			PreparedStatement stmt = dbCon.prepareStatement(qry);
			
			
			// For the first parameter, 
            // get the data using request object 
            // sets the data to st pointer 
            stmt.setInt(1, Integer.valueOf(request.getParameter("id"))); 
            
            // Execute the insert command using executeUpdate() 
            // to make changes in database 
           
            
            out.println("<html><body><b>Below are the details found : "
                    + "<br></b></body></html>"); 
            
            ResultSet rs =  stmt.executeQuery();
    		if(rs.first()) {
	    			int id = rs.getInt(1);
	    			String name = rs.getString(2);
	    			int price = rs.getInt(3);
	    			Date date =rs.getDate(4);
	    			
	    			out.println("<html><body> <b>Emp ID : </b>"+id +"<b> Name : </b>"+name+ "<b> Price : </b>"+price+" <b> Date Added : </b>"+date
	    					+"</body> </html>");
	    		
    		} else {
    			out.println("<html><body> ID doesn't exists </body> </html>");
    		}

			stmt.close();

			conn.closeConnection();


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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

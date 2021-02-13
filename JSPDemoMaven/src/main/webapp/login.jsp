<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login JSP</title>
</head>
<body>
	<%
		String uName = request.getParameter("username");
		String pass = request.getParameter("password");
		
		if(uName.equals("Kanika") && pass.equals("password")){
			session.setAttribute("uName",uName);
			response.sendRedirect("Logout.jsp");
		}else{
			out.println("Invalid Credentials!");
			request.getRequestDispatcher("HomePage.html").include(request,response);
		}
	%>
</body>
</html>
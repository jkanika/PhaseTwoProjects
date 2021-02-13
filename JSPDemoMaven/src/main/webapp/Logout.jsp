<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
	<%
		out.println("Welcome "+session.getAttribute("uName"));
	%>
	<form action="HomePage.html" method ="post">
		<input type ="submit" name ="Logout" value ="logout">
	</form>
	<%
		String logout = request.getParameter("Logout");
		if(logout != null){
			request.getSession().invalidate();
		}
	%>
</body>
</html>
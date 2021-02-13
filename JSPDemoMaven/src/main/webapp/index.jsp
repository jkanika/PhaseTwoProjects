<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Hello Welcome to JSP </h1>
	<p><select>
	<%
		for(int i=300; i<=350;i++){
			%>
			<option> <% out.println(i); %> </option>
		<%}
	%>
	</select></p>
	
	<% 
		String sub = request.getParameter("submit");
		if(sub != null){
		String Fname = request.getParameter("fname");
		out.println("First Name : "+Fname);
		String Lname = request.getParameter("lname");
		out.println("Last Name : "+Lname);
		}
	%>
	
	<!-- Session and context -->
	<% session.setAttribute("uName",request.getParameter("fname")); // set the session value
	application.setAttribute("uName",request.getParameter("lname")); //set the context value
	if(session.getAttribute("uName").equals("admin"))
		response.sendRedirect("UnderMain.html");%>
	
</body>
</html>
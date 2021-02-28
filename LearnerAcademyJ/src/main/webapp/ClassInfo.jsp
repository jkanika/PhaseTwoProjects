<%@page import="java.sql.ResultSet , projectFiles.Logout"%>
<%@ page import = "projectFiles.GetClassDetails" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
<body>
	
	<h1>
	Welcome 
	<%
		out.println(session.getAttribute("adminName")+" !");
	%>
	</h1>	
	<h3>
	<form action='' method='post'>
		<br>
		Enter the class id to see the report : 
		 <select name="id" id="classId">
		 	<option value ='0'> All Class </option>
		 	<% GetClassDetails obj = new GetClassDetails();
		 	   ResultSet classRs = obj.getClassId();
		 	   while(classRs.next()){
		 		   int id = classRs.getInt(1);
		 		   String className = classRs.getString(2);
		 		   %>
		 		   <option value='<%=id%>'> <%=className%></option>
		 	<% } %>
		 </select> <br> <br>
		<input type ='submit' name ='ShowClassInfo' value='Get Class Details'>
		<br> <br>
	</form>
	</h3>
	
	<%
		String submit = request.getParameter("ShowClassInfo");
		if(submit != null){
				int id = Integer.parseInt(request.getParameter("id"));
				ResultSet rs = obj.getClassInfo(id);
				
				if(rs != null) {
					%>
					<table>
								<tr>
									<th> Class ID </th>
									<th> Class Name </th>
									<th> Student ID </th>
									<th> Student Name </th>
									<th> Teacher Name </th>
									<th> Subject Name </th>
								</tr>
						<%
						while(rs.next()) {
							int ClassId = rs.getInt(1);
							String ClassName=rs.getString(2);
							int StId = rs.getInt(3);
							String StName = rs.getString(4);
							String TName = rs.getString(5);
							String SbName = rs.getString(6);
							%>
							
							
								<tr>
									<td> <% out.println(ClassId); %> </td>
									<td> <% out.println(ClassName); %> </td>
									<td> <% out.println(StId); %> </td>
									<td> <% out.println(StName); %> </td>
									<td> <% out.println(TName); %> </td>
									<td> <% out.println(SbName); %> </td>
								</tr>
							
							<% 
						}
					} 
				else{
					out.println("No Data to show!");
				}
			}
		
		String logout = request.getParameter("Logout");
		if(logout != null){
			request.getSession().invalidate();
			response.sendRedirect("index.jsp");
		}
	%>
	</table>
	<form action='logout'>
	<br><br>
	<input type ='submit' name ='Logout' value='Logout'>
		<br> <br>
	</form>
</body>
</html>
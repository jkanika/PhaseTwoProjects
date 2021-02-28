<%@ page import="projectFiles.Login" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner Academy</title>
</head>
<body>
	<h1 style="text-align:center;"> Welcome to Learner Academy </h1>
	<form style="text-align:center;" action ='login' method='post'>
		<label> Admin Email  </label>
		<input type ='email' name='adminMail'> <br> <br>
		<label> Admin Password </label>
		<input type ='password' name='adminPass'> <br><br>
		<input type ='submit' name='Login' value ='Login'>
	</form>
</body>
</html>
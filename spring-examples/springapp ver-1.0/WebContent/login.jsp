<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome-page</title>
</head>
<body bgcolor="blue">
	<center>
		<% 
			if(request.getParameter("userName").equals("admin") && request.getParameter("password").equals("admin"))
			{
		%>
				<h1>Hello :<%="SATENDRA PRATAP SINGH" %></h1>
		<%
			}
			else
			{
		%>
				<h3>Sorry!!!!error in login details....</h3>
		<%
			}
		%>
	</center>
</body>
</html>
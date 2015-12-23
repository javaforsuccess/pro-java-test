<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
<center>
	<div>
		<hr>
		<h1>***WELCOME TO MY APP***</h1>
		<br>
		<hr>
		<i><sub>DETAILS REQUIRED</sub></i>
		<br>
	</div>
	<div>
	<form action="submitDataServlet" method="post">
		<hr>
			Message ID :<input type="text" name="msgId"><br>
			Message Priority:<input type="text"  name="msgPriority"><br>
			Queue Name :<input type="text"  name="queueName"><br>
			Message Body:<input type="text" name="msgBody"><br>
		<hr>
			<input type="submit" value="submit"><input type="reset" value="reset">
			<br>
		<hr>
	</form>
	</div>
	<div>
		
	</div>
</center>
</body>
</html>
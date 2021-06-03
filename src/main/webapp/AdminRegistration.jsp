<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin_Registration</title>
</head>
<body class="rounded mx-auto d-block">
<jsp:include page="header.jsp"></jsp:include>
		<main class="container-fluid">
			
			
			<%
		String errorMessage = request.getParameter("errorMessage");
		if(errorMessage != null){
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
		<div>
	<form action="AdminRegistrationAction" method="get" id="logreg">
			<h3>ADMIN REGISTRATION</h3>
			<strong><label>ENTER YOUR NAME</label></strong><br>
			<input type="text" required placeholder="NAME" autofocus name=adminName><br>
			<strong><label>ENTER YOUR ID :</label></strong><br>
			<input type="number" required placeholder="ID" min=10000 max=10000000  name="adminId"><br>
			<strong><label>ENTER YOUR PASSWORD:</label></strong><br>
			(TESTER NOTE:This password will be encrypted so <br>
			use encrypted password while log in <br>
			ENCRYPTED PASSWORD BE LIKE:"your password"@lib_987)<br>
			<input type="password" required placeholder="PASSWORD" name="adminPassword"><br>
			<strong><label>ENTER YOUR PHONE NO</label></strong><br>
			<input type=number required placeholder="+91" min=1000000000 max=9999999999 name="phoneNo"><br><br>
			<button class="btn btn-primary">SUBMIT</button>&nbsp;
			<input type="reset" value="RESET" class="btn btn-danger">
			</form><br>
			</div>
			</main>
</body>
</html>
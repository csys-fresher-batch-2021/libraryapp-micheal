<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body class="rounded mx-auto d-block">
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<div>
	<h3>USER REGISTRATION</h3>
	<%
		String msg = request.getParameter("msg");
		if(msg != null){
			out.println("<font color='red'>" +"*"+ msg +"*"+ "</font>");
		}
		%>
		
			
			<form action="UserRegistrationAction" method="post">
			<strong><label>ENTER YOU NAME</label></strong><br>
			<input type="text" required name="userName"><br>
		<strong><label>ENTER YOUR USER ID</label></strong><br>
		<input type="number" required min=10000 max=10000000 autofocus name="userId"><br>
		<strong><label>ENTER YOUR PASSWORD</label></strong><br>
		<input type="password" required name="password" ><br>
		<strong><label>ENTER YOUR MOBLE NO.</label></strong><br>
		<input type=number required placeholder="+91" min=1000000000 max=9999999999 name="phoneNo"><br><br>
		<button class="btn btn-primary">SUBMIT</button> <input type="reset" class="btn btn-danger">
		</form>
		</div>
		

	</main>
</body>
</html>
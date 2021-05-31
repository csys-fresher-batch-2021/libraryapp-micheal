<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="in.micheal.model.BookDetail" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body class="rounded mx-auto d-block">
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<div>
	<h3>USER LOGIN</h3>
		<%
		String Message = request.getParameter("msg");
		if(Message != null){
			out.println("<font color='green'>" + Message + "</font>");
		}
		%>
		<%
		String Msg = request.getParameter("errorMessage");
		if(Msg != null){
			out.println("<font color='red'>" + Msg + "</font>");
		}
		%>
		
		
		
		<form action="UserLoginAction" method="post" >
		<strong><label>ENTER YOUR USER ID</label></strong><br>
		<input type="number" required min=10000 max=10000000 autofocus name="userId" ><br>
		<strong><label>ENTER YOUR PASSWORD</label></strong><br>
		<input type="password" required name="password"><br><br>
		<button class="btn btn-primary">SUBMIT</button> <input type="reset" class="btn btn-danger">
		</form><br><br>
		<a  href="UserRegistration.jsp" id="link">REGISTER</a>
		</div>
		
		
		
		

	</main>
</body>
</html>
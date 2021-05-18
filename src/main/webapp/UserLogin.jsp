<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>USER LOGIN</h3>
	<%
		String Message = request.getParameter("msg");
		if(Message != null){
			out.println("<font color='green'>" + Message + "</font>");
		}
		%>
		<form>
		<strong><label>ENTER YOUR USER ID</label></strong><br>
		<input type="number" required min=10000 max=10000000 autofocus><br>
		<strong><label>ENTER YOUR PASSWORD</label></strong><br>
		<input type="password" required ><br><br>
		<button class="btn btn-primary">SUBMIT</button> <input type="reset" class="btn btn-danger">
		</form><br><br>
		<a href=UserRegistration.jsp>REGISTER</a>
		
		
		

	</main>
</body>
</html>
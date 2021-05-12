<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
		<main class="container-fluid">
			<h3>ADMIN REGISTRATION</h3>
			
			<%
		String errorMessage = request.getParameter("errorMessage");
		if(errorMessage != null){
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
	<form action="AdminRegistrationAction" method="get">
	
			<strong><label>ENTER YOUR ID :</label></strong><br>
			<input type="number" required placeholder="ID" min=10000 max=10000000 autofocus name="adminId"><br>
			<strong><label>ENTER YOUR PASSWORD :</label></strong><br>
			<input type="password" required placeholder="PASSWORD" min=10000 max=10000000 name="adminPassword"><br>
			<strong><label>ENTER YOUR EMAIL</label></strong><br>
			<input type="email" required placeholder="EMAIL"><br>
			<strong><label>ENTER YOUR PHONE NO</label></strong><br>
			<input type=number required placeholder="+91" min=999999999 max=9999999999><br><br>
			<button class="btn btn-primary">SUBMIT</button>&nbsp &nbsp &nbsp
			<input type="reset" value="RESET" class="btn btn-danger">
			</form><br>
			</main>
</body>
</html>
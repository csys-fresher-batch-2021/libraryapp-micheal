<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
	<form action="AdminRegistrationAction.jsp">
	
			<b><label>ENTER YOUR ID :</label></b><br>
			<input type="number" required placeholder="ID" min=10000 max=10000000 autofocus name="adminId"><br>
			<b><label>ENTER YOUR PASSWORD :</label></b><br>
			<input type="password" required placeholder="PASSWORD" min=10000 max=10000000 name="adminPassword"><br>
			<b><label>ENTER YOUR EMAIL</label></b><br>
			<input type="email" required placeholder="EMAIL"><br>
			<b><label>ENTER YOUR PHONE NO</label></b><br>
			<input type=number required placeholder="+91" min=999999999 max=9999999999><br><br>
			<input type="submit" value="SUBMIT" class="btn btn-primary">&nbsp &nbsp &nbsp
			<input type="reset" value="RESET" class="btn btn-danger">
			</form><br>
			</main>
</body>
</html>
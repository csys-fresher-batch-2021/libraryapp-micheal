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
		<h3>ADMIN LOGIN</h3>

		<%
		String infoMessage = request.getParameter("infoMessage");
		if (infoMessage != null) {
			out.println("<font color='green'>" + infoMessage + "</font>");
		}
		%>
		<%
		String errorMessage = request.getParameter("errorMessage");
		if(errorMessage != null)
		{
			out.println("<font color ='red'>" +errorMessage + "</font>");
		}
		%>
		<form action="AdminLoginAction" method="post">
			<strong><label>ENTER YOUR ID :</label></strong><br> 
			<input type="number" required placeholder="ID" name="adminId" min=10000 max=10000000 autofocus><br>
			 <strong><label>ENTER YOUR PASSWORD :</label></strong><br> 
				<input type="password" name="password" required placeholder="PASSWORD"><br> <br>
			<input type="submit" value="SUBMIT" class="btn btn-primary">&nbsp;
			<input type="reset" value="RESET" class="btn btn-danger">
		</form>
		<br> <a href="AdminRegistration.jsp">Register</a>


	</main>
</body>
</html>
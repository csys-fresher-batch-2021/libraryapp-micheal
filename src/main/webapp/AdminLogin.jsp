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
			<h3>ADMIN LOGIN</h3>
			
				<%
		String infoMessage= request.getParameter("infoMessage");
		if(infoMessage != null){
			out.println("<font color='green'>" + infoMessage + "</font>");
		}
		%>
			<form>
			<b><label>ENTER YOUR ID :</label></b><br>
			<input type="number" required placeholder="ID" min=10000 max=10000000 autofocus><br>
			<b><label>ENTER YOUR PASSWORD :</label></b><br>
			<input type="password" required placeholder="PASSWORD" min=10000 max=10000000><br><br>
			<input type="submit" value="SUBMIT" class="btn btn-primary">&nbsp &nbsp &nbsp<input type="reset" value="RESET" class="btn btn-danger">
			</form><br>
			
			<a href="AdminRegistration.jsp">Register</a>
			
			
			</main>
</body>
</html>
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
	<h3>USER REGISTRATION</h3>
	<%
		String msg = request.getParameter("msg");
		if(msg != null){
			out.println("<strong><font color='red'>" + msg + "</font></strong>");
		}
		%>
		
			<form action="UserRegistrationAction" method="post">
		<strong><label>ENTER YOUR USER ID</label></strong><br>
		<input type="number" required min=10000 max=10000000 autofocus name="userId"><br>
		<strong><label>ENTER YOUR PASSWORD</label></strong><br>
		<input type="password" required name="password" ><br>
		<strong><label>ENTER YOUR MOBLE NO.</label></strong><br>
		<input type=number required placeholder="+91" min=1000000000 max=9999999999><br><br>
		<button class="btn btn-primary">SUBMIT</button> <input type="reset" class="btn btn-danger">
		</form>
		

	</main>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin_View</title>
</head>
<body class="rounded mx-auto d-block">
	<jsp:include page="AdminHeader.jsp"></jsp:include>
	<main class="container-fluid">
	<%
		HttpSession AdminUser = request.getSession();
		Long loggedInUsername = (Long) AdminUser.getAttribute("LOGGED_IN_USER");
		if(loggedInUsername==null)
			response.sendRedirect("AdminLogin.jsp");
		%>
		<div><h3>WELCOME TO THE ADMIN PANEL</h3></div>
	<div>
	<%String msg=request.getParameter("msg");
	if(msg!=null)
		out.println("<font color='brown'>"+msg+"</font>");
	%>
		<form action="UploadBooksAction" method="post" id="uploadBooks">
		<h3>UPLOAD BOOKS</h3>
		<strong><label>ENTER THE BOOK NAME TO UPLOAD</label></strong><br>
		<input type="text" required name="bookName" placeholder="Book Name"><br>
		<strong><label>ENTER THE QUANTITY</label></strong><br>
		<input type="number" required name="bookQuantity" placeholder="Quantity"><br><br>
		<button class="btn btn-info">SUBMIT</button>
		</form>
		</div><br><br>
		
		</main>
</body>


</html>
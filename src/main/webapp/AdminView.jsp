
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="rounded mx-auto d-block">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<div>
	<h3>WELCOME TO THE ADMIN PANEL</h3>
	<%String msg=request.getParameter("msg");
	if(msg!=null)
		out.println("<font color='brown'>"+msg+"</font>");
	%>
		<form action="UploadBooksAction" method="post">
		<label>ENTER THE BOOK NAME TO UPLOADED</label><br>
		<input type="text" required name="bookName"><br>
		<label>ENTER THE QUANTITY</label><br>
		<input type="number" required name="bookQuantity"><br><br>
		<button class="btn btn-info">SUBMIT</button>
		</form>
		</div>
		</main>
</body>

</html>
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
	<h3>TAKE OR RETURN BOOK</h3><br><br>
	<form action="TakeOrReturnBookButtonAction" method="post">
	<input type="radio"  name="takeorreturnbook" value="takeBook">&nbsp; &nbsp;<label>TAKE BOOK</label><br>
	<input type="radio"  name="takeorreturnbook" value="returnBook">&nbsp; &nbsp;<label>RETURN BOOK</label><br>
	<button class="btn btn-info">SUBMIT</button>
	</form>
	<%String msg=request.getParameter("msg");
	if(msg!=null)
		out.println("<font color='brown'>"+msg+"</font>");
	%>
	<%String verification=request.getParameter("verification");
	if(verification != null)
		if(verification.equals("takeBook")){
			
	%>
	<form action="TakeBookAction" method="post">
	<label>ENTER THE BOOK NAME</label><br>
	<input type="text" required placeholder="BOOK NAME" name="bookName"><br>
	<label>ENTER THE BOOK QUANTITY</label><br>
	<input type="number" required placeholder="BOOK QUANTITY" name="bookQuantity"><br><br>
	<button class="btn btn-info">SUBMIT</button>&nbsp;&nbsp;<input type="reset" class="btn btn-danger">
	</form>
	
	<%} else  {%>
	<form>
	<label>ENTER THE RETURNING BOOK NAME</label><br>
	<input type="text" required placeholder="BOOK NAME"><br>
	<label>ENTER THE RETURNING BOOK QUANTITY</label><br>
	<input type="number" required placeholder="BOOK QUANTITY"><br><br>
	<button class="btn btn-info">SUBMIT</button>&nbsp;&nbsp;<input type="reset" class="btn btn-danger">
	</form>
	
	<% } %>
	
	</main>
</body>
</html>
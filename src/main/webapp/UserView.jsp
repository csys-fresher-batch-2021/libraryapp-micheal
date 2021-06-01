<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="in.micheal.model.BookDetail"%>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User View</title>
</head>
<body class="rounded mx-auto d-block">
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<%
		HttpSession loggedInUser = request.getSession();
		Long loggedInUsername = (Long) loggedInUser.getAttribute("LOGGED_IN_USER");
		if(loggedInUsername==null)
			response.sendRedirect("UserLogin.jsp");
		%>
	<div>
	<h3>TAKE OR RETURN BOOK</h3><br><br>
	<form action="TakeOrReturnBookButtonAction" method="post">
	<input type="radio"  name="takeorreturnbook" value="takeBook" required style="margin-left:-25px">&nbsp; &nbsp;<strong><label>TAKE BOOK</label></strong><br>
	<input type="radio"  name="takeorreturnbook" value="returnBook" required>&nbsp; &nbsp;<strong><label>RETURN BOOK</label></strong><br>
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
	<h3>TAKE BOOK</h3><br>
	<strong><label>ENTER THE BOOK NAME</label></strong><br>
	<input type="text" required placeholder="BOOK NAME" name="bookName" id="bookName"><br>
	<strong><label>ENTER THE BOOK QUANTITY</label></strong><br>
	<input type="number" required placeholder="BOOK QUANTITY" name="bookQuantity" min=1 id="bookQuantity"><br><br>
	<button class="btn btn-info">SUBMIT</button>&nbsp;&nbsp;<input type="reset" class="btn btn-danger">
	</form>







			<%} else  {%>
	<form action="ReturnBookAction" method="post">
	<h3>RETURN BOOK</h3><br>
	<strong><label>ENTER THE RETURNING BOOK NAME</label></strong><br>
	<input type="text" required placeholder="BOOK NAME" name="bookName" id="bookName"><br>
	<strong><label>ENTER THE RETURNING BOOK QUANTITY</label></strong><br>
	<input type="number" required placeholder="BOOK QUANTITY" name="bookQuantity" id="bookQuantity"><br><br>
	<button class="btn btn-info">SUBMIT</button>&nbsp;&nbsp;<input type="reset" class="btn btn-danger">
	</form><br><br>
	
	<h3>BOOKS TAKEN BY YOU</h3>
	<table class="table table-hover table-dark">
	<thead>
	<tr>
				<th>S.no</th>
				<th>BOOK NAME</th>
				<th>QUANTITY</th>
			</tr>
	</thead>
	<tbody>
	<%int i=0;
	List<BookDetail> debtUserBooks = (ArrayList<BookDetail>) request.getAttribute("debtUserBooks"); 
	if(debtUserBooks!=null)
	for(BookDetail obj:debtUserBooks){
		i++;
	%>
			<tr>
				<td><%=i %></td>
				<td><%=obj.getName() %></td>
				<td><%=obj.getQuantity() %></td>
				
			</tr>
			<%} %>
	</tbody>
	</table>
	
	
	
	<% } %>
	
	</div>
	</main>
</body>
<script>
function autoLoad()
{
	let book=JSON.parse(localStorage.getItem("bookS"))||null;
	if(book!=null)
	document.querySelector("#bookName").value=book.BookName;
	document.querySelector("#bookQuantity").value=book.Quantity;
	localStorage.setItem("bookS",null);
	}
	autoLoad();
</script>
</html>
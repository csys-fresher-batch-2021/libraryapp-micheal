
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="in.micheal.dao.BookDetailsDAO"%>
<%@ page import="in.micheal.model.BookDetail"%>
<%@ page import="in.micheal.dao.DebtUserDetailsDAO" %>
<%@ page import="in.micheal.model.DebtUserDetail" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Welcome To Library Management</h3>
		<h4>ALL AVAILABLE BOOKS</h4>
		<table class="table table-dark table-hover">
			<caption>ALL AVAILABLE BOOKS</caption>
			<thead>
				<tr>
					<th>S.no</th>
					<th>BOOK NAME</th>
					<th>BOOK QUANTITY</th>
				</tr>
			</thead>
			<tbody>

				<%
				List<BookDetail> bookDetails = BookDetailsDAO.getBookDetails();
				int i = 0;
				for (BookDetail obj : bookDetails) {
					i++;
				%>
				<tr>
					<td><%=i%></td>
					<td><%=obj.getName()%></td>
					<td><%=obj.getQuantity()%></td>
				</tr>

				<%
				}
				%>
			</tbody>
		</table><br>
		<form action="UploadBooksAction" method="post">
		<h4>UPLOAD BOOKS</h4>
		<%
		String msg=request.getParameter("message");
		if(msg!=null)
		out.println("<strong><font color='green'>"+msg+ "</font></strong>");
		%><br><br>
		<input type="text" required placeholder="BOOK NAME" name="bookName"><br><br>
		<input type="number" required placeholder="BOOK QUANTITY" name="bookQuantity" min=1 max=100000><br><br>
		<button class="btn btn-danger">SUBMIT</button>
		
		</form><br><br>
		<h4>ALL DEBT USERS</h4>
		<table class="table table-dark table-hover">
		<caption>ALL DEBT USERS</caption>
		<thead>
		<tr>
					<th>S.no</th>
					<th>USER ID</th>
					<th>TAKEN BOOK</th>
					<th>TAKEN QUANTITY</th>
					<th>TAKEN DATE</th>
				</tr>
				</thead>
				<tbody>
				<% 
				List<DebtUserDetail> debtUserDetails=DebtUserDetailsDAO.getDebtUserDetail();
				int j=0;
				for(DebtUserDetail debtUser:debtUserDetails){
					j++;
				%>
				<tr>
				<td><%=j %></td>
				<td><%=debtUser.getDebtUserId() %></td>
				<td><%=debtUser.getTakenBook() %></td>
				<td><%=debtUser.getTekenBookQuantity() %></td>
				<td><%=debtUser.getTakenDate() %></td>
				</tr>
				
				<%} %>
				</tbody>
		
		
		</table>
		
	</main>
</body>

</html>
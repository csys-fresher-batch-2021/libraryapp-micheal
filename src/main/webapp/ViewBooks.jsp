<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="in.micheal.dao.BookDetailsDAO"%>
<%@ page import="in.micheal.model.BookDetail"%>
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
		<h3>ALL AVAILABLE BOOKS</h3>
		<table class="table table-dark table-hover">
		<caption>ALL AVAILABLE BOOKS</caption>
			<thead>
				<tr>
					<th> S.no</th>
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
		</table>


	</main>
</body>
</html>
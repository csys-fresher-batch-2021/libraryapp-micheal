<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="AdminHeader.jsp"></jsp:include>
	<main class="container-fluid">

<div>
		<form action="PayFineAction" method="get">
		<%
		String Message = request.getParameter("fineMsg");
		if(Message != null){
			out.println("<font color='green'>" + Message + "</font>");
		}
		%>
		<%
		String Msg = request.getParameter("errorMsg");
		if(Msg != null){
			out.println("<font color='red'>" + Msg + "</font>");
		}
		%>
		<h3>PAY BILLS</h3>
		<strong><label>ENTER THE USER ID:</label></strong><br>
		<input type="number" required placeholder="USER ID" min=10000 max=10000000 autofocus name="userid"><br><br>
		<button class="btn btn-warning">PAY</button>
		</form>
		</div>
		<div><br>
		</div>
		</main>
</body>
</html>

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
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<%
		HttpSession loggedInUser = request.getSession();
		Long loggedInUsername = (Long) loggedInUser.getAttribute("LOGGED_IN_USER");
		if(loggedInUsername==null)
			response.sendRedirect("AdminLogin.jsp");
		%>
	<div>
	<h3>WELCOME TO THE ADMIN PANEL</h3>
	<%String msg=request.getParameter("msg");
	if(msg!=null)
		out.println("<font color='brown'>"+msg+"</font>");
	%>
		<form action="UploadBooksAction" method="post">
		<strong><label>ENTER THE BOOK NAME TO UPLOAD</label></strong><br>
		<input type="text" required name="bookName" placeholder="Book Name"><br>
		<strong><label>ENTER THE QUANTITY</label></strong><br>
		<input type="number" required name="bookQuantity" placeholder="Quantity"><br><br>
		<button class="btn btn-info">SUBMIT</button>
		</form>
		</div><br><br>
		<div>
		<button class="btn btn-info" onclick="viewAllRecords()">VIEW ALL RECORDS</button><br><br>
		<table class="table table-hover table-dark">
		<thead>
			<tr>
			<th>S.no</th>
			<th>USER ID</th>
			<th>TAKEN BOOK</th>
			<th>TAKEN QUANTITY</th>
			<th>TAKEN DATE</th>
			</tr>
		</thead>
		<tbody id="allrecords"></tbody>	
		
		</table>
		</div>
		</main>
</body>
<script>
function viewAllRecords(){
	let url = "ViewAllRecords";
	fetch(url).then(res=> res.json()).then(res=>{
		let allRecords = res;
		let content = "";
		let i=0;
		for(let user of allRecords){
				i++;
				content += "<tr><td>" + i + "</td><td>" + user.debtUserId +
				"</td><td>" + user.takenBook + "</td><td>" + user.tekenBookQuantity + 
				"</td><td>" + user.takenDate + "</td></tr>";
			}
		document.querySelector("#allrecords").innerHTML= content;
	});
}
</script>

</html>
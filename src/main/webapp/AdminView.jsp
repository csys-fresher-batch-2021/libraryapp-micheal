
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin_View</title>
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
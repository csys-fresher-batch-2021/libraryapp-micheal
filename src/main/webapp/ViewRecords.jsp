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
	<%
		HttpSession AdminUser = request.getSession();
		Long loggedInUsername = (Long) AdminUser.getAttribute("LOGGED_IN_USER");
		if(loggedInUsername==null){
			response.sendRedirect("AdminLogin.jsp");
		}
		else {
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache"); 
			response.setDateHeader("Expires", 0);
		}
		%>
	
	<h3>ALL RECORDS</h3><br><br>

<table class="table table-hover table-dark">
<caption>All available records</caption>
		<thead>
			<tr>
			<th scope="col">S.no</th>
			<th scope="col">USER ID</th>
			<th scope="col">TAKEN BOOK</th>
			<th scope="col">TAKEN QUANTITY</th>
			<th scope="col">TAKEN DATE</th>
			</tr>
		</thead>
		<tbody id="allrecords"></tbody>	
		
		</table>
		
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
				"</td><td>" + user.strDate + "</td></tr>";
			}
		document.querySelector("#allrecords").innerHTML= content;
	});
}
viewAllRecords();

</script>
</html>
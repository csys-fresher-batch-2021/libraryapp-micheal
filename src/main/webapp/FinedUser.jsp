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
		if (loggedInUsername == null)
			response.sendRedirect("AdminLogin.jsp");
		%>

		<h3>ALL RECORDS</h3>
		<br>
		<br>

		<table class="table table-hover table-dark">
			<caption>Fined Users</caption>
			<thead>
				<tr>
					<th scope="col">S.no</th>
					<th scope="col">USER ID</th>
					<th scope="col">FINE AMOUNT</th>

				</tr>
			</thead>
			<tbody id="allrecords"></tbody>

		</table>

	</main>
</body>
<script>
function viewFinedRecords(){
	let url = "ViewFinedUsers";
	fetch(url).then(res=> res.json()).then(res=>{
		let allRecords = res;
		let content = "";
		let i=0;
		for(let user of allRecords){
				i++;
				if(user.fineAmount>0){
				content += "<tr><td>" + i + "</td><td>" + user.debtUserId +
				"</td><td>"+user.fineAmount+"</td></tr>";
				}
			}
		document.querySelector("#allrecords").innerHTML= content;
	});
}
viewFinedRecords();
</script>

</html>
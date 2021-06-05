<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="AdminHeader.jsp"></jsp:include>
	<main class="container-fluid">
	
	<h3>ALL RECORDS</h3><br><br>

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
viewAllRecords();

</script>
</html>
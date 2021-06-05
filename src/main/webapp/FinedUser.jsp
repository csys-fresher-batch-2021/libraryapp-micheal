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
	
	<h3>ALL RECORDS</h3><br><br>

<table class="table table-hover table-dark">
		<thead>
			<tr>
			<th>S.no</th>
			<th>USER ID</th>
			<th>FINE AMOUNT</th>
			
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="in.micheal.model.BookDetail"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
</head>
<body class="rounded mx-auto d-block">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div>
			<form onsubmit="searchResults()" method="get">
				<strong><label>SEARCH BOOKS :</label></strong><br> <input
					type="text" placeholder="BOOK NAME" id="bookname" name="bookname">
				<button class="btn btn-info">SUBMIT</button>
			</form>
			<br> <br> <label>AVAILABLE BOOKS</label>
			<table class="table table-hover table-dark">
				<thead>
					<tr>
						<th>S.no</th>
						<th>BOOK NAME</th>
						<th>QUANTITY</th>
					</tr>
				</thead>
				<tbody id="book_tbl">

				</tbody>
			</table>
		</div>
	</main>
</body>
<script>
function searchResults()
{
	event.preventDefault();
		let bookName=document.querySelector("#bookname").value;
		let url="ViewBookByNameAction?bookName=" + bookName;
		axios.get(url).then(res=> {
		let searchedBooks=res.data;
		let content="";
		let i=0;
		for(let book of searchedBooks)
			{
			i++;
			content+="<tr><td>"+ i +"</td><td>"+book.bookName+"</td><td>"+book.bookQuantity+"</td></tr>";	
			}
	
		document.querySelector("#book_tbl").innerHTML= content;

	} );

	}

</script>
</html>
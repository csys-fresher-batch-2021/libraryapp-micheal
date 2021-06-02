<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>Search_Books</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
</head>
<body class="rounded mx-auto d-block">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	
		<div>
			<form onsubmit="searchResults()" method="get">
			<h3>SEARCH BOOKS</h3><br>
				<input type="search" placeholder="BOOK NAME" required id="bookname" name="bookname">
				<button class="btn btn-info">SEARCH</button>
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
		let bookN="";
		let quant=null;
		let content="";
		let i=0;
		for(let book of searchedBooks)
			{
			i++;
			bookN=book.bookName;
			quant=book.bookQuantity;
			content+="<tr><td>"+ i +"</td><td>"+book.bookName+"</td><td>"+book.bookQuantity+" </td><td><button onclick=\"saveBook(('"+bookN+"'),('"+quant+"'))\" ' class='btn btn-warning'>Take Book</button></td></tr>";
			
			}
			
		document.querySelector("#book_tbl").innerHTML= content;

	} );

	}
function saveBook(bookName,bookQuantity)
{
	event.preventDefault();
	let bookS={"BookName":bookName,"Quantity":bookQuantity};
	localStorage.setItem("bookS",JSON.stringify(bookS));
	window.location = "UserLogin.jsp?errorMessage="+"Login Required";
	}

</script>
</html>
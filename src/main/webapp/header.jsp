<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">

<%
HttpSession loggedInUser = request.getSession();
Long loggedInUsername = (Long) loggedInUser.getAttribute("LOOGGED_IN_USER");
%>

<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="#">LIBRARY MANAGEMENT</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavId">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
    
    <%if(loggedInUsername==null)
    {
    %>
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="SearchBooks.jsp">Search Books</a>
      </li>
    </ul>
     <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="UserLogin.jsp">Login</a>
      </li>
      </ul>
      <%} else{ %>
      <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
      <li class="nav-item active">
      <a class="nav-link" href="LogOutAction">LOG OUT</a>
      </li>
      </ul>
      
      <%} %>
   
  </div>
</nav>
</header>
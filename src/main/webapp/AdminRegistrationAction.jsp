  <%@page import="in.micheal.service.*"%>
  <%@page import="in.micheal.validator.*"%>
  <%@page import="in.micheal.model.*"%>
<%
long adminId=Long.parseLong(request.getParameter("adminId"));
 String password=request.getParameter("adminPassword");
 
 UserDetails admin=new UserDetails();
 admin.setUserId(adminId);
 admin.setAdminPassword(password);
 
 boolean confirmation=UserService.adminRegistration(admin);
 
 if(confirmation)
 {
	 String message="ADMIN ID ADDED SUCCESSFULLY";
	 response.sendRedirect("AdminLogin.jsp?infoMessage=" + message);
 }
 else
 {
	 String message="ADMIN ID ALREADY EXISTS";
	 response.sendRedirect("AdminRegistration.jsp?errorMessage=" + message);
 }
%>
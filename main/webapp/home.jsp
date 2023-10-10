<%@page import="Model.userModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<%
	userModel um = null;
	if (session.getAttribute("data") != null) {
		um = (userModel) session.getAttribute("data");
	} else {
		response.sendRedirect("loginpage.jsp");
	}
	%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="homepage.jsp">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="logout.jsp">Logout
						<%=um.getFname()%></a></li>
				<li class="nav-item"><a class="nav-link"
					href="ChangePassword.jsp?id=<%=um.getId() %>" tabindex="-1" aria-disabled="true">Change
						Password</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>